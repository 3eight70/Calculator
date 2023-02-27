package com.example.calc

import androidx.core.content.ContextCompat

class Calculate {
    private var newNumberFlag=false
    private var signs = listOf('+', '-','×', '÷')
    private var curNumber=""
    private var newNumber=""
    private var text=""
    private var sign:Char=' '
    private var commaInCurNumber=false
    private var commaInNewNumber=false
    var main=MainActivity()

    fun clear(): String{
        curNumber=""
        newNumber=""
        newNumberFlag=false
        commaInCurNumber=false
        commaInNewNumber=false
        return curNumber
    }

    fun removeLastChar(): String{
        if (curNumber=="Error"){
            clear()
        }
        else if (newNumber.isNotEmpty()){
            if (newNumber.last()=='.'){
                commaInNewNumber=false
            }
            newNumber=newNumber?.replaceFirst(".$".toRegex(), "").toString()
            text=curNumber+newNumber
            return text
        }
        else if (curNumber.isNotEmpty() && newNumber.isEmpty()){
            if (curNumber.last()=='.'){
                commaInCurNumber=false
            }
            curNumber=curNumber?.replaceFirst(".$".toRegex(), "").toString()
            return curNumber
        }
        return ""
    }

    fun addSymbol(symbol:Char): String{
        if ("Error" in curNumber){
            clear()
        }

        if (curNumber.isNotEmpty() && (curNumber[curNumber.length-1] in signs || curNumber[curNumber.length-1]=='%') && (symbol in signs || symbol=='%') && newNumber.isEmpty()){
            curNumber=curNumber.substring(0, curNumber.length-1)
            curNumber+=symbol
            return curNumber
        }

        else if ((symbol in signs || symbol=='%') && newNumber.isEmpty() && curNumber.isNotEmpty()){
            curNumber+=symbol
            newNumberFlag=true
            return curNumber
        }

        else if (newNumberFlag==false){
            if (curNumber.length>0 && symbol in signs){
                curNumber+=symbol
                return curNumber
            }

            else if (curNumber.length>0 && symbol==',' && commaInCurNumber==false){
                curNumber+='.'
                commaInCurNumber=true
                return curNumber
            }
            else if (curNumber.length>0 && commaInCurNumber==false && symbol=='0' && curNumber.first()=='0'){
                return curNumber
            }
            else if (symbol !in signs && symbol!='%' && symbol!=','){
                if (curNumber.length>0 && curNumber.first()=='0' && commaInCurNumber==false){
                    curNumber=symbol.toString()
                    return curNumber
                }
                curNumber += symbol
                return curNumber
            }
        }

        else if (newNumber.isNotEmpty() && newNumberFlag==true && checkSign(symbol)){
            curNumber = equal()
            if (curNumber!="Error"){
                curNumber+=symbol
            }
            return curNumber
        }

        else if (newNumberFlag==true && (curNumber[curNumber.length-1] in signs || curNumber[curNumber.length-1]=='%')){
            if (symbol==',' && commaInNewNumber==false && newNumber.isNotEmpty()){
                newNumber+='.'
                commaInNewNumber=true
                return curNumber+newNumber
            }
            else if (newNumber.length>0 && commaInNewNumber==false && symbol=='0' && newNumber.first()=='0'){
                return curNumber+newNumber
            }
            else if (symbol!=',') {
                if (newNumber.length>0 && newNumber.first()=='0' && commaInNewNumber==false){
                    newNumber=symbol.toString()
                    return curNumber+newNumber
                }
                newNumber += symbol
                return curNumber + newNumber
            }
        }
        else if (symbol!=','){
            curNumber+=symbol
            newNumberFlag=false
            return curNumber
        }
        return curNumber+newNumber
    }

    fun checkSign(symbol: Char):Boolean{
        if ((curNumber[curNumber.length-1] in signs || curNumber[curNumber.length-1]=='%') && (symbol in signs || symbol == '%') ){
            sign=curNumber[curNumber.length-1]
            curNumber=main.removeLastChar(curNumber).toString()
            return true
        }
        return false
    }

    fun equal(): String{
        var answer: Double=0.0
        if (curNumber.last() !in signs && curNumber.last()!='%'){
            answer=curNumber.toDouble()
        }

        if (curNumber[curNumber.length-1] in signs || curNumber[curNumber.length-1]=='%'){
            sign=curNumber[curNumber.length-1]
            curNumber=main.removeLastChar(curNumber).toString()
            answer=curNumber.toDouble()
        }
        if (newNumber.isNotEmpty()) {
            when (sign) {
                '+' -> answer = curNumber.toDouble() + newNumber.toDouble()
                '-' -> answer = curNumber.toDouble() - newNumber.toDouble()
                '×' -> answer = curNumber.toDouble() * newNumber.toDouble()
                '÷' -> answer = curNumber.toDouble() / newNumber.toDouble()
                '%' -> answer = curNumber.toDouble() / 100 * newNumber.toDouble()
            }
        }
        else{
            when(sign){
                '%'->answer=curNumber.toDouble()/100
            }
        }

        newNumber=""
        commaInNewNumber=false
        commaInCurNumber=true
        curNumber=checkError(answer)
        return curNumber
    }

    fun changeSign(): String{
        if (newNumber.isEmpty()){
            var temp:Char=' '
            var flag=false
            if (curNumber[curNumber.length-1] in signs || curNumber[curNumber.length-1]=='%'){
                temp=curNumber[curNumber.length-1]
                flag=true
                curNumber=curNumber.substring(0,curNumber.length-1)
            }
            if (curNumber.toDouble()>0) {
                curNumber = '-' + curNumber
            }
            else{
                curNumber=curNumber.substring(1,curNumber.length)
            }
            if (flag==true) {
                flag=false
                curNumber+=temp
                return curNumber
            }
            else{
                flag=false
                return curNumber
            }
        }
        else{
            curNumber=equal()
            if (curNumber.toDouble()>0) {
                curNumber = '-' + curNumber
            }
            else{
                curNumber=curNumber.substring(1,curNumber.length)
            }
            curNumber='-'+curNumber
            return curNumber
        }
    }

    private fun setError(): String{
        newNumberFlag=false
        newNumber=""
        curNumber="Error"
        commaInCurNumber=false
        commaInNewNumber=false
        return curNumber
    }

    private fun checkError(number: Double): String{
        if (number.isInfinite() || number.isNaN()){
            return setError()
        }
        return number.toString()
    }
}