package com.wencong.mvpcode.base

open class BasePresenter<V : Contract.BaseView?, M : Contract.BaseModel?>(view: V) :
    IBasePresenter {
    protected var mView: V?
    protected var mModel: M? = null
    protected fun attach(model: M) {
        mModel = model
    }

    override fun detach() {
        if (mView != null) {
            mView = null
        }
    }

    init {
        mView = view
    }
}