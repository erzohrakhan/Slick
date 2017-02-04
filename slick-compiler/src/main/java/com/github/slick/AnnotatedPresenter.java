package com.github.slick;

import com.squareup.javapoet.ClassName;

import java.util.List;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2017-02-01
 */

class AnnotatedPresenter {
    private List<PresenterArgs> args;
    private ClassName view;
    private ClassName viewType;
    private ClassName viewInterface;
    private ClassName presenter;
    private ClassName PresenterHost;

    AnnotatedPresenter(String viewCanonicalName, List<PresenterArgs> args, ClassName view, ClassName viewType,
                       ClassName presenter,
                       ClassName presenterHost) {
        if (viewCanonicalName == null) {
            throw new IllegalArgumentException(new Throwable("viewCanonicalName cannot be null")); // TODO: 2017-02-01 error
        }
        this.view = view;
        this.viewType = viewType;
        this.presenter = presenter;
        PresenterHost = presenterHost;
        this.args = args;

        final String[] split = viewCanonicalName.split("\\.");
        StringBuilder builder = new StringBuilder(viewCanonicalName.length());
        for (int i = 0; i < split.length - 1; i++) {
            builder.append(split[i]).append(".");
        }
        //remove the extra dot
        if (split.length > 1) builder.deleteCharAt(builder.length() - 1);
        viewInterface = ClassName.get(builder.toString(), split[split.length - 1]);
    }

    ClassName getViewInterface() {
        return viewInterface;
    }

    public List<PresenterArgs> getArgs() {
        return args;
    }

    public ClassName getPresenterHost() {
        return PresenterHost;
    }

    public ClassName getPresenter() {
        return presenter;
    }

    public ClassName getViewType() {
        return viewType;
    }

    public ClassName getView() {
        return view;
    }
}