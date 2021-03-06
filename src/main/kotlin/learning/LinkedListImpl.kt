data class NNode<T>(var value: T, var next: NNode<T>? = null){
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

class LinkedList<T>{

    private var head: NNode<T>? = null
    private var tail: NNode<T>? = null
    private var size = 0

    /**
     * adds a node in the start
     */
    fun push(value:T): LinkedList<T> {
        head = NNode(value, head)
        if(tail == null){
            tail = head
        }
        size++
        return this
    }

    /**
     * Adding item at the end of the LinkedList
     */
    fun append(value: T):LinkedList<T>{
        val node = NNode(value)
        if(isEmpty()) {
            push(value)
        }else{
            tail?.next = node
            tail = tail?.next
            size++
        }
        return this;
    }

    fun getNodeAt(index:Int): NNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while(currentNode != null && currentIndex < index ){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insertAfterNode(value:T, afterNode:NNode<T>?): LinkedList<T> {
        return if(tail ==  afterNode){
            append(value)
        }else{
            val n = NNode(value, afterNode?.next)
            afterNode?.next = n
            size++
            this
        }
    }

    fun pop(): LinkedList<T> {
        if(!isEmpty()) size--
        if(head!=null){
            head = head?.next
        }
        if(isEmpty()){
            tail = null
        }
        return this
    }

    fun removeLast() : LinkedList<T> {
        if (head==null) return this
        if(head?.next == null){
            size--;
            return pop()
        }

        var previous = head
        var current = head
        var next:NNode<T>? = head?.next

        while (next != null){
            previous = current
            current = next
            next = current.next
        }
        previous?.next = null
        tail = previous
        return this
    }

    fun removeAfter(node: NNode<T>?): LinkedList<T>{
        if(node?.next == tail) {
            tail = node
        }

        if(node?.next != null){
            size--
        }
        node?.next = node?.next?.next
        return this
    }

    fun isEmpty(): Boolean {
        return size == 0
    }


    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    fun getSize(): Int {
        return size;
    }
}



fun main(){
    val linkedList = LinkedList<Int>()
    linkedList.append(1).append(2).append(3).append(4).push(0).push(-1).push(23).append(78)
    println(linkedList)
    println(linkedList.getSize())
    println(linkedList.isEmpty())
    linkedList.insertAfterNode(89, linkedList.getNodeAt(2))
    println(linkedList)
    linkedList.pop().pop()
    println(linkedList)
    linkedList.removeLast().removeLast().removeLast()
    println(linkedList)
    val nodeToRemove = linkedList.getNodeAt(0)
    linkedList.removeAfter(nodeToRemove)
    println(linkedList)
}

