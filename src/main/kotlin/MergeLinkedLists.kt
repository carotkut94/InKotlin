class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class MergeLinkedLists {

    private fun merge(list1: ListNode?, list2: ListNode?) : ListNode?{
        if(list1 == null) return list2
        if(list2 == null) return list1
        return if(list1.`val`<=list2.`val`){
            list1.next = merge(list1.next, list2)
            list1
        }else{
            list2.next = merge(list1, list2.next)
            list2
        }
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        if(l1==null) return l2
        if(l2==null) return l1

        if(l1.`val` > l2.`val`){
            val temp = l1
            l1 = l2
            l2 = temp
        }
        val result = l1
        while (l1!=null && l2!=null){
            var tmp:ListNode? = null
            while (l1!=null && l1.`val` <= l2.`val`){
                tmp = l1
                l1 = l1.next
            }
            tmp?.next = l2
            val temp = l1
            l1 = l2
            l2 = temp
        }
        return result
    }
}