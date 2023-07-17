package com.example.project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ProgressBar
import com.example.project3.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

class FSM() {
    var state_ = States.IDLE

    enum class States(var value: Int) {
        IDLE(0),
        STARTED(1);

        companion object {
            fun fromInt(value: Int) = States.values().first { it.value == value }
        }
    }

    fun changeState(newStates: States) {
        println("FSM: ${toString(state_)} -> ${toString(newStates)}")
        state_ = newStates
    }

    fun getAsInt(): Int {
        return state_.value
    }

    fun setAsInt(newStates: Int) {
        var newState1 = States.fromInt(newStates)
        changeState(newState1)
    }

    fun toString(states: States): String {
        return when {
            states == States.IDLE -> "IDLE"
            states == States.STARTED -> "STARTED"
            else -> "UNKNOWN"
        }
    }
}

class Model() {
    val MIN = 0
    val MAX = 100

    //  private var counter_: AtomicInteger = 0
    var counter_ = 0
    private val INCRIMENT = 10

    fun counterToString(): String {
        return counter_.toString()
    }

    fun getCounter(): Int {
        return counter_
    }

    fun stopCounting() {
//        counter_ = 0
        setCounter(0)
    }

    fun bigIncrement() {
        if (counter_ < MAX) {
            counter_ += INCRIMENT
        }
    }

    fun setCounter(value: Int) {
        counter_ = value
    }

    fun bigDecrement() {
        if (counter_ > MIN) {
            counter_ -= INCRIMENT
        }
    }

    fun decrement() {
        if (counter_ > MIN) {
            counter_ -= 1
        }
    }
}

class MainActivity : AppCompatActivity() {
    var fsm = FSM()
    var isStartNow_ = true
    var model_ = Model()
    var thread_: Thread? = null
    var canceledCounting_ = AtomicBoolean(false)

    private fun stop(binding: ActivityMainBinding) {
        canceledCounting_.set(true)
        model_.stopCounting()
        draw(binding)
        activateStartButton(binding, true)
//          thread_?.interrupt(
        isStartNow_ = true
        model_.stopCounting()
        binding.start.isEnabled = true
        binding.buttonIncriment.isEnabled = true
        binding.buttonDecrement.isEnabled = true
        binding.slider.isEnabled = true
        binding.slider.value = 0F
        draw(binding)
    }

    override fun onDestroy() {
        super.onDestroy()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        stop(binding)
    }

    private fun activateStartButton(binding: ActivityMainBinding, started: Boolean) {
        binding.start.isEnabled = started
        binding.stop.isEnabled = !started
    }

    private fun draw(binding: ActivityMainBinding) {
        val circleProgress = findViewById<ProgressBar>(R.id.progressBarCircle)
        circleProgress.progress = model_.getCounter()
        binding.centerText.text = model_.counterToString()
        binding.slider.value = model_.getCounter().toFloat()
        println("from drow ${binding.centerText.text}")

    }

    override fun onSaveInstanceState(outState: Bundle) {
//        println("111")
        outState.putInt("counter", model_.getCounter())
        outState.putInt("fsm", fsm.getAsInt())
//        println("${fsm.getAsInt()}")
//        outState.putInt("slider", model_.counter_)
//        outState.putString("text", model_.counterToString())

        super.onSaveInstanceState(outState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

//        println("on instance ${savedInstanceState?.getInt("counter")}")

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        savedInstanceState?.getInt("counter", 0)?.let {
//            binding.slider.value = it.toFloat()
//        }

        binding.slider.valueFrom = model_.MIN.toFloat()
        binding.slider.valueTo = model_.MAX.toFloat()
        binding.slider.stepSize = 1F


//        savedInstanceState?.let {
//            bundle ->
//
//        }

        if (savedInstanceState != null) {
//            println("222")
            model_.counter_ = savedInstanceState.getInt("counter")
            var t = savedInstanceState.getInt("fsm")
            fsm.setAsInt(t)
//            println("${savedInstanceState.getInt("fsm")}")

//            binding.slider.value = savedInstanceState.getInt("slider").toFloat()
        }
        if (fsm.state_ == FSM.States.STARTED) {
            start(binding)
        }
        draw(binding)
//        println("A")

        binding.slider.addOnChangeListener { slider, value, fromUser ->
            model_.setCounter(value.toInt())
//            println("B")
            draw(binding)
        }
//        savedInstanceState?.let { bundle ->
//            bundle.getInt("counter", 0)
//            bundle.getString("text", "zero")
//            draw(binding)
//        }


        binding.centerText.text = model_.counterToString()

        binding.buttonIncriment.setOnClickListener {
            model_.bigIncrement()
            binding.slider.value = model_.getCounter().toFloat()
//            println("C")
            draw(binding)
        }

        binding.buttonDecrement.setOnClickListener {
            model_.bigDecrement()
            binding.slider.value = model_.getCounter().toFloat()
//            println("D")
            draw(binding)
        }

        binding.start.setOnClickListener {
            fsm.changeState(FSM.States.STARTED)
            start(binding)
        }

        binding.stop.setOnClickListener {
            fsm.changeState(FSM.States.IDLE)
            stop(binding)
        }
//        model_.getCounter()
    }

    fun start(binding: ActivityMainBinding) {
        if (isStartNow_) {
            activateStartButton(binding, false)
            canceledCounting_.set(false)
            val counter = model_.getCounter() // UI
            thread_ = thread {
                runBlocking { // thread0
//                  val counter = model_.getCounter() // thread 0 race condition
                    for (i in counter downTo 0) { // thread 0
                        if (canceledCounting_.get()) {
                            break
                        }
                        delay(1000) //thread 0
                        runOnUiThread() { // thred 0
                            model_.decrement() // UI
//                            println("E")
                            draw(binding) // UI
                        }
                    }
                }
            }
            //UI
            isStartNow_ = false
            binding.buttonIncriment.isEnabled = false
            binding.buttonDecrement.isEnabled = false
            binding.slider.isEnabled = false

        } else {
//                canceledCounting_.set(true)
//                model_.toZero()
//                draw(binding)
//                activateStartButton(binding, true)
//            thread_?.interrupt(
//                isStartNow_ = true
        }
    }
}