package com.example.hmw12.databinding;
import com.example.hmw12.R;
import com.example.hmw12.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMainBindingImpl extends FragmentMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener editandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of view_model.observer.text
            //         is view_model.observer.setText((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edit);
            // localize variables for thread safety
            // view_model.observer != null
            boolean viewModelObserverJavaLangObjectNull = false;
            // view_model.observer
            com.example.hmw12.MainViewModel.MyObservable viewModelObserver = null;
            // view_model != null
            boolean viewModelJavaLangObjectNull = false;
            // view_model
            com.example.hmw12.MainViewModel viewModel = mViewModel;
            // view_model.observer.text
            java.lang.String viewModelObserverText = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelObserver = viewModel.getObserver();

                viewModelObserverJavaLangObjectNull = (viewModelObserver) != (null);
                if (viewModelObserverJavaLangObjectNull) {




                    viewModelObserver.setText(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.EditText) bindings[1]
            , (android.widget.ProgressBar) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.edit.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progress.setTag(null);
        this.textview.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.view_model == variableId) {
            setViewModel((com.example.hmw12.MainViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.hmw12.MainViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.view_model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelObserver((com.example.hmw12.MainViewModel.MyObservable) object, fieldId);
            case 1 :
                return onChangeViewModelState((kotlinx.coroutines.flow.StateFlow<com.example.hmw12.State>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelObserver(com.example.hmw12.MainViewModel.MyObservable ViewModelObserver, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.text) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelState(kotlinx.coroutines.flow.StateFlow<com.example.hmw12.State> ViewModelState, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewModelStateText = null;
        com.example.hmw12.MainViewModel viewModel = mViewModel;
        int viewModelStateInstanceofStateLoadingViewVISIBLEViewGONE = 0;
        com.example.hmw12.MainViewModel.MyObservable viewModelObserver = null;
        kotlinx.coroutines.flow.StateFlow<com.example.hmw12.State> viewModelState = null;
        com.example.hmw12.State viewModelStateGetValue = null;
        boolean viewModelStateInstanceofStateLoading = false;
        java.lang.String viewModelObserverText = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x1dL) != 0) {

                    if (viewModel != null) {
                        // read view_model.observer
                        viewModelObserver = viewModel.getObserver();
                    }
                    updateRegistration(0, viewModelObserver);


                    if (viewModelObserver != null) {
                        // read view_model.observer.text
                        viewModelObserverText = viewModelObserver.getText();
                    }
            }
            if ((dirtyFlags & 0x16L) != 0) {

                    if (viewModel != null) {
                        // read view_model.state
                        viewModelState = viewModel.getState();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 1, viewModelState);


                    if (viewModelState != null) {
                        // read view_model.state.getValue()
                        viewModelStateGetValue = viewModelState.getValue();
                    }


                    if (viewModelStateGetValue != null) {
                        // read view_model.state.getValue().text
                        viewModelStateText = viewModelStateGetValue.getText();
                    }
                    // read view_model.state.getValue() instanceof State.Loading
                    viewModelStateInstanceofStateLoading = viewModelStateGetValue instanceof com.example.hmw12.State.Loading;
                if((dirtyFlags & 0x16L) != 0) {
                    if(viewModelStateInstanceofStateLoading) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read view_model.state.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
                    viewModelStateInstanceofStateLoadingViewVISIBLEViewGONE = ((viewModelStateInstanceofStateLoading) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1dL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edit, viewModelObserverText);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edit, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x16L) != 0) {
            // api target 1

            this.progress.setVisibility(viewModelStateInstanceofStateLoadingViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textview, viewModelStateText);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): view_model.observer
        flag 1 (0x2L): view_model.state
        flag 2 (0x3L): view_model
        flag 3 (0x4L): view_model.observer.text
        flag 4 (0x5L): null
        flag 5 (0x6L): view_model.state.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
        flag 6 (0x7L): view_model.state.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}