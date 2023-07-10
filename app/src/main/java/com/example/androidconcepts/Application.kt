package com.example.androidconcepts

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
  
  //https://teams.microsoft.com/l/meetup-join/19%3ameeting_MzcxZjQ4ZjYtZjQ5NS00NTYzLWEwNDMtMjI4YzdiOTM4ODU1%40thread.v2/0?context=%7b%22Tid%22%3a%22cc55ca6d-1316-47a9-8cb2-a791739443e6%22%2c%22Oid%22%3a%222b9b7968-48ae-44d0-848d-b6b0bd1320d5%22%7d
//https://cocubes.in/onebancassessment



//JUST COMPLETED
 
Assessment
OneBanc | CAST | 2021
 
Time Taken
14 minutes 54 seconds
 
Submitted On
17 Jun, 2023 03:21 PM
 
Candidate ID
38278881}



import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


/*
 * Complete the 'consecutive' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts LONG_INTEGER num as parameter.
 */

fun consecutive(num: Long): Int {
    // Write your code here
    var c =0
    val l= (Math.sqrt(2*num.toDouble())+1).toInt()
    for(n in 2 until l) {
        if((2*num)%n == 0.toLong()) {
            val k = ((2*num)/n - n+1).toInt()
            if(k>0 && k%2 == 0) {
                c++
            }
        }
    
    }
    return c
}
fun main(args: Array<String>) {
    val num = readLine()!!.trim().toLong()

    val result = consecutive(num)

    println(result)
}


















import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


/*
 * Complete the 'getMinimumDifference' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. STRING_ARRAY a
 *  2. STRING_ARRAY b
 */

fun getMinimumDifference(a: Array<String>, b: Array<String>): Array<Int> {
    // Write your code here
    var m : Array<Int> = Array(a.size){ index -> 0}
    for(i in 0..a.size-1) {
        val noOfChangesNeeded = checkAnagrams(a[i],b[i])
        m.set(i, noOfChangesNeeded)
    }
    
    return m
}
// fun buildFrequencyMap(string: String): Map<Char, Int> {
//     val freqMap = mutableMapOf<Char, Int>()
  
//     for (char in string) {
//         freqMap[char] = freqMap.getOrDefault(char, 0) + 1
//     }
  
//     return freqMap
// }
// fun findMinCharChanges(string1: String, string2: String): Int {
//     val freqMap1 = buildFrequencyMap(string1)
//     val freqMap2 = buildFrequencyMap(string2)
  
//     var count = 0
  
//     for (char in freqMap1.keys) {
//         val freq1 = freqMap1[char] ?: 0
//         val freq2 = freqMap2[char] ?: 0
//         count += kotlin.math.abs(freq1 - freq2)
//     }
  
//     for (char in freqMap2.keys) {
//         if (!freqMap1.containsKey(char)) {
//             count += freqMap2[char] ?: 0
//         }
//     }
  
//     return count
// }
fun checkAnagrams(a : String , b : String): Int {
    val aMap = HashMap<Char ,Int>()
    val bMap = HashMap<Char ,Int>()
    if(a.length != b.length) 
       return -1
       
    for(i in 0..a.length-1) {
        aMap.put(a[i], (aMap.get(a[i])?:0)+1)
    }
    
    for(i in 0..b.length-1) {
        bMap.put(b[i], (bMap.get(b[i])?:0)+1)
    }
    //aMap.size==bMap.size
    //aMap.value != bMap.value
    
    if(bMap == aMap) 
      return 0
    if(bMap.size != aMap.size) 
      return -1
      
    for(i in aMap) {
        val count = i.value
        for(j in 0..count-1){
        if(bMap.contains(i.key)) {
            var k = bMap.get(i.key)?:0
            k--
            if(k == 0) {
                bMap.remove(i.key)
            }else {
               bMap.set(i.key,k) 
            }
            
            var k1 = aMap.get(i.key)?:0
            k1--
            if(k1 == 0) {
                aMap.remove(i.key)
            }else {
               aMap.set(i.key,k1) 
            }
        }
        }
    }  
    // var p = HashSet<Char>()
    // for(j in aMap) {
    //     p.add(j.key)
    // }
    // for(k in bMap) {
    //     p.remove(k.key)
    // }
    // if(p.size !=0) 
    //   return -1
    
      
    var ct = 0
    for(j in aMap) {
        ct+=j.value
    }
    return ct
}
fun main(args: Array<String>) {
    val aCount = readLine()!!.trim().toInt()

    val a = Array<String>(aCount, { "" })
    for (i in 0 until aCount) {
        val aItem = readLine()!!
        a[i] = aItem
    }

    val bCount = readLine()!!.trim().toInt()

    val b = Array<String>(bCount, { "" })
    for (i in 0 until bCount) {
        val bItem = readLine()!!
        b[i] = bItem
    }

    val result = getMinimumDifference(a, b)

    println(result.joinToString("\n"))
}



fun countManipulations(s1: String, s2: String): Int {
    var count = 0
    val charCount = IntArray(26)
    
    for (i in s1.indices) {
        charCount[s1[i] - 'a']++
    }
    
    for (i in s2.indices) {
        charCount[s2[i] - 'a']--
    }
    
    for (i in charCount.indices) {
        if (charCount[i] != 0) {
            count += Math.abs(charCount[i])
        }
    }
    
    return count / 2
}
