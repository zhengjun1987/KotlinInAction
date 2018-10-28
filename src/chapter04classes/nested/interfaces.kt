package chapter04classes.nested

import java.io.Serializable

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/28 17:16
 *   Project:KotlinInAction
 */

interface State:Serializable

interface View {
    fun getCurrentState():State
    fun restoreState(state: State){}
}