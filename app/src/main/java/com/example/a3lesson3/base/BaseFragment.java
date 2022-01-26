package com.example.a3lesson3.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<ViewModel extends BaseViewModel, Binding extends ViewBinding> extends Fragment {

    protected ViewModel viewModel;
    protected Binding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setUpRequests();
        setUpObserves();

    }

    protected void initialize() {
    }

    protected void setUpRequests() {
    }

    protected void setUpObserves() {
    }
}
