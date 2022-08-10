package com.personal.mviwithdaggerhilt

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.flow.*

fun main() {
    val temp = flow {
        var startingValue = 10
        while (startingValue > 0) {
            delay(2000)
            startingValue--
            emit(startingValue)
        }
    }.flowOn(Dispatchers.Default)

    flowOf(4, 2, 5, 1, 7)
        .onEach {
            delay(400)
            println(it)
        }
        .flowOn(Default)


//    CoroutineScope(Dispatchers.Default).launch {
//        temp.collectLatest { println(it) }
//    }


}