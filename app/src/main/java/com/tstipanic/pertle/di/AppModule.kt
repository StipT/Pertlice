package com.tstipanic.pertle.di

import com.tstipanic.pertle.comments_screen.presenter.CommentsFragPresenter
import com.tstipanic.pertle.comments_screen.presenter.CommentsFragPresenterImpl
import com.tstipanic.pertle.comments_screen.presenter.CommentsPresenter
import com.tstipanic.pertle.comments_screen.presenter.CommentsPresenterImpl
import com.tstipanic.pertle.comments_screen.view.CommentsView
import com.tstipanic.pertle.comments_screen.view.fragments.CommentsFragView
import com.tstipanic.pertle.dedication_screen.presenter.DedicationPresenter
import com.tstipanic.pertle.dedication_screen.presenter.DedicationPresenterImpl
import com.tstipanic.pertle.dedication_screen.view.DedicationView
import com.tstipanic.pertle.learning_screen.presenter.LearningPresenter
import com.tstipanic.pertle.learning_screen.presenter.LearningPresenterImpl
import com.tstipanic.pertle.learning_screen.view.LearningView
import com.tstipanic.pertle.model.interactor.Interactor
import com.tstipanic.pertle.model.interactor.InteractorImpl
import com.tstipanic.pertle.splash_screen.presenter.SplashPresenter
import com.tstipanic.pertle.splash_screen.presenter.SplashPresenterImpl
import com.tstipanic.pertle.splash_screen.view.SplashView
import org.koin.dsl.module

val splashModule = module { factory<SplashPresenter> { (view: SplashView) -> SplashPresenterImpl(view) } }

val dedicationModule =
    module { factory<DedicationPresenter> { (view: DedicationView) -> DedicationPresenterImpl(view) } }

val learningModule = module { factory<LearningPresenter> { (view: LearningView) -> LearningPresenterImpl(view) } }

val commentsModule = module {

    factory<CommentsPresenter> { (view: CommentsView) -> CommentsPresenterImpl(view) }
    factory<CommentsFragPresenter> { (view: CommentsFragView) -> CommentsFragPresenterImpl(view, get()) }
    factory<Interactor> { InteractorImpl() }

}