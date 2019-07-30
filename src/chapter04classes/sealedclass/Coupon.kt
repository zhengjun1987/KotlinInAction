package chapter04classes.sealedclass

sealed class Coupon(val id:Long,val type:String) {
    companion object {
        val TYPE_CASH = "CASH"
        val TYPE_DISCOUNT = "DISCOUNT"
        val TYPE_GIFT = "GIFT"

        val STATE_NOT_FETCHED = 1
        val STATE_FETCHED = 2
        val STATE_USED = 3
        val STATE_EXPIRED = 4
        val STATE_INVALID = 5

        fun fetched(coupon: Coupon,user: User):Boolean {return false}
    }

    class CashCoupon(id:Long,val leastCost:Long,val reduceCost:Long):Coupon(id, TYPE_CASH)
    class DiscountCoupon(id: Long,val discount:Int):Coupon(id, TYPE_DISCOUNT)
    class GiftCoupon(id: Long,val gift:String):Coupon(id, TYPE_GIFT)
}

class User