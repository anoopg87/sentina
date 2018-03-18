package au.com.sentina.ui.adapter

interface OnClickListener<in D: Any> {
    fun  onClick(d: D,pos: Int)
}