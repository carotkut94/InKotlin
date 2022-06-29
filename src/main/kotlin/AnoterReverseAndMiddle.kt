class AnotherReverseAndMiddle {
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var previous: ListNode? = null
        while (current != null) {
            val temp = current.next
            current.next = previous
            previous = current
            current = temp
        }

        return previous
    }

    fun middleNode(head: ListNode?): ListNode? {
        var l = 0
        var current = head
        while (current != null) {
            l += 1
            current = current.next
        }
        if (l == 1) {
            return head
        }

        val middle = l / 2
        current = head
        l = 0
        while (current != null) {
            l += 1
            if (l == middle) {
                return current.next
            } else {
                current = current.next
            }
        }
        return current
    }

    fun middleSlowFast(head: ListNode?):ListNode?{
        var slow = head
        var fast = head
        while(fast?.next != null){
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    fun detectCycle(head: ListNode?): ListNode? {
        val table = mutableMapOf<ListNode?, Boolean>()
        var current = head
        var cycleFound = false
        if(head==null || head.next==null){
            return null
        }
        while (current!=null || !cycleFound ){
            table.put(current, true)
            current = current?.next
            if(table.containsKey(current)){
                return current
            }
        }
        return null
    }
}