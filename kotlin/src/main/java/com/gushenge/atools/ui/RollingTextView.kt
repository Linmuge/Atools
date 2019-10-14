package com.gushenge.atools.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatTextView

import com.gushenge.atools.R

import java.text.DecimalFormat
import java.util.concurrent.Executors

/**
 * @Description 自带数字滚动动画的TextView
 * @Author 一花一世界
 */
class RollingTextView constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyleAttr) {

    // 总共跳跃的帧数，默认30跳
    private var frameNum: Int = 0
    // 内容的类型，默认是金钱类型
    private var textType: Int = 0
    // 是否使用每三位数字一个逗号的格式，让数字显得比较好看，默认使用
    private var useCommaFormat: Boolean = false
    // 是否当内容有改变才使用动画,默认是
    private var runWhenChange: Boolean = false
    // 1个线程的线程池
    private val threadPool = Executors.newFixedThreadPool(1)
    // 格式化金额，保留两位小数
    private val formatter = DecimalFormat("0.00")

    private var nowMoneyNum = 0.00// 记录每帧增加后的金额数字
    private var finalMoneyNum: Double = 0.toDouble()// 目标金额数字（最终的金额数字）

    private var nowNum: Int = 0//记录每帧增加后的数字
    private var finalNum: Int = 0//目标数字（最终的数字）
    private var preStr: String? = null

    private val handler = @SuppressLint("HandlerLeak") object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                //金额数字的滚动
                MONEY-> {
                    //保留两位小数的字符串
                    val str = formatter.format(nowMoneyNum).toString()
                    // 更新显示的内容
                    this@RollingTextView.text = if (useCommaFormat) {
                        //使用每三位数字一个逗号格式的字符串
                        val formatStr = addComma(str, true)
                        formatStr
                    } else {
                        str
                    }

                    //记录当前每帧递增后的数字
                    nowMoneyNum += msg.obj as Double

                    if (nowMoneyNum < finalMoneyNum) {
                        //如果当前记录的金额数字小于目标金额数字，即还没达到目标金额数字，继续递增
                        val msg2 = this.obtainMessage()
                        msg2.what = MONEY
                        msg2.obj = msg.obj
                        // 继续发送通知改变UI
                        this.sendMessage(msg2)
                    } else {
                        //已经达到目标的金额数字，显示最终的数字
                        this@RollingTextView.text =if (useCommaFormat) {
                            addComma(formatter.format(finalMoneyNum), true)
                        } else {
                            formatter.format(finalMoneyNum)
                        }
                    }
                }
                //普通数字滚动
                NUM-> {
                    // 更新显示的内容
                    this@RollingTextView.text = if (useCommaFormat) {
                        //使用每三位数字一个逗号格式的字符串
                        addComma(nowNum.toString(), false)
                    } else {
                        nowNum.toString()
                    }

                    //记录当前每帧递增后的数字
                    nowNum += msg.obj as Int
                    if (nowNum < finalNum) {
                        //如果当前记录的数字小于目标数字，即还没达到目标数字，继续递增
                        val msg2 = this.obtainMessage()
                        msg2.what = NUM
                        msg2.obj = msg.obj
                        // 继续发送通知改变UI
                        this.sendMessage(msg2)
                    } else {
                        //已经达到目标的数字，显示最终的内容
                        this@RollingTextView.text = if (useCommaFormat) {
                            addComma(finalNum.toString(), false)
                        } else {
                            finalNum.toString()
                        }
                    }
                }
            }
        }
    }

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.RollingTextView)
        frameNum = ta.getInt(R.styleable.RollingTextView_frameNum, 30)
        textType = ta.getInt(R.styleable.RollingTextView_textType, MONEY)
        useCommaFormat = ta.getBoolean(R.styleable.RollingTextView_useCommaFormat, true)
        runWhenChange = ta.getBoolean(R.styleable.RollingTextView_runWhenChange, true)
    }

    /**
     * @Description 帧数
     */
    fun setFrameNum(frameNum: Int) {
        this.frameNum = frameNum
    }

    /**
     * @Description 内容的格式
     */
    fun setTextType(textType: Int) {
        this.textType = textType
    }

    /**
     * @Description 是否设置每三位数字一个逗号
     */
    fun setUseCommaFormat(useCommaFormat: Boolean) {
        this.useCommaFormat = useCommaFormat
    }

    /**
     * @Description 是否当内容改变的时候使用动画，反之则不使用动画
     */
    fun setRunWhenChange(runWhenChange: Boolean) {
        this.runWhenChange = runWhenChange
    }

    /**
     * @Description 设置需要滚动的金钱(必须为正数)或整数(必须为正数)的字符串
     */
    fun setContent(str: String) {
        //如果是当内容改变的时候才执行滚动动画,判断内容是否有变化
        if (runWhenChange) {
            if (TextUtils.isEmpty(preStr)) {
                //如果上一次的str为空
                preStr = str
                useAnimByType(str)
                return
            }

            //如果上一次的str不为空,判断两次内容是否一致
            if (preStr == str) {
                //如果两次内容一致，则不做处理
                return
            }

            //如果两次内容不一致，记录最新的str
            preStr = str
        }
        useAnimByType(str)
    }

    private fun useAnimByType(str: String) {
        if (textType == MONEY) {
            startMoneyAnim(str)
        } else {
            startNumAnim(str)
        }
    }

    /**
     * @Description 开始金额数字动画的方法
     */
    fun startMoneyAnim(moneyStr: String) {
        // 如果传入的数字已经格式化了，则将包含的符号去除
        val money = moneyStr.replace(",", "").replace("-", "")
        try {
            finalMoneyNum = java.lang.Double.parseDouble(money)
            if (finalMoneyNum == 0.0) {
                // 如果传入的数字为0则直接使用setText()进行显示
                this@RollingTextView.text = moneyStr
                return
            }
            nowMoneyNum = 0.0
            threadPool.execute {
                val msg = handler.obtainMessage()
                // 将传入的数字除以帧数，得到每帧间隔的大小
                val size = finalMoneyNum / frameNum
                msg.what = MONEY
                // 如果每帧的间隔小于0.01，则设置间隔为0.01
                msg.obj = if (size < 0.01) 0.01 else size
                // 发送消息改变UI
                handler.sendMessage(msg)
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            //如果转换Double失败则直接用setText()
            this@RollingTextView.text = moneyStr
        }

    }

    /**
     * @Description 开始数字动画的方法
     */
    fun startNumAnim(numStr: String) {
        // 如果传入的数字已经格式化了，则将包含的符号去除
        val num = numStr.replace(",", "").replace("-", "")
        try {
            finalNum = num.toInt()
            if (finalNum < frameNum) {
                // 如果传入的数字比帧数小，则直接使用setText()
                this@RollingTextView.text = numStr
                return
            }
            // 默认从0开始动画
            nowNum = 0
            threadPool.execute {
                val msg = handler.obtainMessage()
                // 将传入的数字除以帧数，得到每帧间隔的大小
                val temp = finalNum / frameNum
                msg.what = NUM
                msg.obj = temp
                // 发送消息改变UI
                handler.sendMessage(msg)
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            this@RollingTextView.text = numStr
        }

    }

    companion object {

        const val MONEY = 0
        const val NUM = 1


        /**
         * @param str       字符串只能为两位小数或者整数
         * @param isDecimal 是否是小数
         * @Description 格式化字符串，每三位用逗号隔开
         */
        fun addComma(str: String, isDecimal: Boolean): String {
            var str = str
            //先将字符串颠倒顺序
            str = StringBuilder(str).reverse().toString()
            if (str == "0") {
                return str
            }
            var str2 = ""
            for (i in str.indices) {
                if (i * 3 + 3 > str.length) {
                    str2 += str.substring(i * 3, str.length)
                    break
                }
                str2 += str.substring(i * 3, i * 3 + 3) + ","
            }
            if (str2.endsWith(",")) {
                str2 = str2.substring(0, str2.length - 1)
            }
            //最后再将顺序反转过来
            val temp = StringBuilder(str2).reverse().toString()
            return if (isDecimal) {
                //去掉最后的","
                temp.substring(0, temp.lastIndexOf(",")) + temp.substring(
                    temp.lastIndexOf(",") + 1,
                    temp.length
                )
            } else {
                temp
            }
        }
    }
}