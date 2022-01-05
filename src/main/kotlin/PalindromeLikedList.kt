class Node(private val item:Int, var next:Node?=null){
    override fun toString():String{
        return if(next!=null){
            "$item -> ${next.toString()}"
        }else{
            "$item"
        }
    }

    fun isPalindrome(head:Node?):Boolean{
        if(head?.next == null){
            return true
        }
        val mid = middle(head)
        var last = reverseLinkedList(mid.next)
        var currentNode = head
        while(last!=null){
            if(last.item!=currentNode?.item){
                return false
            }
            last = last.next
            currentNode = currentNode.next
        }
        return true
    }

    private fun reverseLinkedList(pivot:Node?):Node?{
        var currentNode:Node? = pivot
        var prevNode:Node? = null
        while(currentNode!=null){
            val tempNode = currentNode.next
            currentNode.next = prevNode
            prevNode = currentNode
            currentNode = tempNode
        }
        return prevNode
    }

    private fun middle(head:Node):Node{
        var slow = head
        var fast = head
        while(fast.next != null && fast.next!!.next != null){
            slow = slow.next!!
            fast = fast.next!!.next!!
        }
        return slow
    }
}

fun main(){
    val n1 = Node(1)
    val n2 = Node(2)
    val n3 = Node(3)
    val n4 = Node(2)
    val n5 = Node(1)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    println(n1)
    println("${n1.isPalindrome(n1)}")
}