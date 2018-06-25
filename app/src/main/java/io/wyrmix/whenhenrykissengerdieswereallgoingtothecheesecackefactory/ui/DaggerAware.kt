package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui

import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityComponent

/**
 * Boilerplate functionality that is required by Dagger2's architecture.
 *
 * This interface isn't needed by dagger, but is used in our base classes to
 * enforce that the activities inject themselves, so you don't forget.
 *
 * @author Renee Vandervelde
 */
interface DaggerAware {
    /**
     * Boilerplate required by Dagger2 for injecting the current object.
     *
     * This method is just boilerplate and should always be implemented exactly as:
     *
     * public void injectSelf(ActivityComponent component) {
     * component.inject(this);
     * }
     *
     * Make sure the class is added as an explicit method in the
     * `ActivityComponent` class.
     *
     * @see ActivityComponent
     *
     * @param component Activity-level Dependency Component for doing injections.
     */
    fun injectSelf(component: ActivityComponent)
}