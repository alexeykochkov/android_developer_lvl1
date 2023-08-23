package com.example.hmw12;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0015\u0010\t\u001a\u00060\nR\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/hmw12/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "jobFindText", "Lkotlinx/coroutines/Job;", "getJobFindText", "()Lkotlinx/coroutines/Job;", "setJobFindText", "(Lkotlinx/coroutines/Job;)V", "observer", "Lcom/example/hmw12/MainViewModel$MyObservable;", "getObserver", "()Lcom/example/hmw12/MainViewModel$MyObservable;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/hmw12/State;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "state_", "Lkotlinx/coroutines/flow/MutableStateFlow;", "findText", "", "text", "", "MyObservable", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.hmw12.State> state_ = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.hmw12.State> state = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.hmw12.MainViewModel.MyObservable observer = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job jobFindText;
    
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.hmw12.State> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hmw12.MainViewModel.MyObservable getObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.coroutines.Job getJobFindText() {
        return null;
    }
    
    public final void setJobFindText(@org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.Job p0) {
    }
    
    public final void findText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048\u0006@FX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/hmw12/MainViewModel$MyObservable;", "Landroidx/databinding/BaseObservable;", "(Lcom/example/hmw12/MainViewModel;)V", "value", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "app_debug"})
    public final class MyObservable extends androidx.databinding.BaseObservable {
        @org.jetbrains.annotations.NotNull()
        @androidx.databinding.Bindable()
        private java.lang.String text = "";
        
        public MyObservable() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getText() {
            return null;
        }
        
        public final void setText(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
    }
}