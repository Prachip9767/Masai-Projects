package ug.sharma.daggerdemo

import dagger.Component


@Component
interface CarCompo {
    fun getBike():Bike
}