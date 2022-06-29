class AnotherReverseAndMiddle {
        fun reverseList(head: ListNode?): ListNode? {
            var current = head
            var previous:ListNode? = null
            while(current!=null){
                val temp = current.next
                current.next = previous
                previous = current
                current = temp
            }

            return previous
        }
}