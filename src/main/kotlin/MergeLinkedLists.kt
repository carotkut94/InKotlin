class ListNode(var value: Int) {
    var next: ListNode? = null
}


class MergeLinkedLists {

    private fun merge(list1: ListNode?, list2: ListNode?) : ListNode?{
        if(list1 == null) return list2
        if(list2 == null) return list1
        return if(list1.value<=list2.value){
            list1.next = merge(list1.next, list2)
            list1
        }else{
            list2.next = merge(list1, list2.next)
            list2
        }
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return merge(list1, list2)
    }
}