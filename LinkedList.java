/**
 * Represents a list of Nodes. 
 */
public class LinkedList {
	
	private Node first; // pointer to the first element of this list
	private Node last;  // pointer to the last element of this list
	private int size;   // number of elements in this list
	
	/**
	 * Constructs a new list.
	 */ 
	public LinkedList () {
		first = null;
		last = first;
		size = 0;
	}
	
	/**
	 * Gets the first node of the list
	 * @return The first node of the list.
	 */		
	public Node getFirst() {
		return this.first;
	}

	/**
	 * Gets the last node of the list
	 * @return The last node of the list.
	 */		
	public Node getLast() {
		return this.last;
	}
	
	/**
	 * Gets the current size of the list
	 * @return The size of the list.
	 */		
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Gets the node located at the given index in this list. 
	 * 
	 * @param index
	 *        the index of the node to retrieve, between 0 and size
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than the list's size
	 * @return the node at the given index
	 */		
	public Node getNode(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException(
					"index must be between 0 and size");
		}
		//// Replace the following statement with your code
		return null;
	}
	
	/**
	 * Creates a new Node object that points to the given memory block, 
	 * and inserts the node at the given index in this list.
	 * <p>
	 * If the given index is 0, the new node becomes the first node in this list.
	 * <p>
	 * If the given index equals the list's size, the new node becomes the last 
	 * node in this list.
     * <p>
	 * The method implementation is optimized, as follows: if the given 
	 * index is either 0 or the list's size, the addition time is O(1). 
	 * 
	 * @param block
	 *        the memory block to be inserted into the list
	 * @param index
	 *        the index before which the memory block should be inserted
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than the list's size
	 */
	public void add(int index, MemoryBlock block) {
		if(index<0 || index>size){
			 throw new IllegalArgumentException("Index is out of bounds"); }
		Node temp= new Node(block);
		if(index==0){ temp.next= first; this.first=temp;size++;
			return;}
		else if(index==size){last.next=temp; last=temp;size ++;return;}
		 else{ Node temp2 = this.first;
		for(int i=0; i<index-1;i++){
			temp2=temp2.next;
			}
			temp.next=temp2.next;
			temp2.next=temp;
		}
		size++;
		
		}

	/**
	 * Creates a new node that points to the given memory block, and adds it
	 * to the end of this list (the node will become the list's last element).
	 * 
	 * @param block
	 *        the given memory block
	 */
	public void addLast(MemoryBlock block) {
		this.add(this.size,block);
	}
	
	/**
	 * Creates a new node that points to the given memory block, and adds it 
	 * to the beginning of this list (the node will become the list's first element).
	 * 
	 * @param block
	 *        the given memory block
	 */
	public void addFirst(MemoryBlock block) {
		this.add(0,block);
	}

	/**
	 * Gets the memory block located at the given index in this list.
	 * 
	 * @param index
	 *        the index of the retrieved memory block
	 * @return the memory block at the given index
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than or equal to size
	 */
	public MemoryBlock getBlock(int index) {
		if(index<0 || index>= size){ 
			throw new IllegalArgumentException("Index is out of bounds"); }
			Node temp= this.first;
			for(int i=0;i<index;i++){
				temp=temp.next;
			}

			MemoryBlock ans= temp.block;

		return ans;
	}	

	/**
	 * Gets the index of the node pointing to the given memory block.
	 * 
	 * @param block
	 *        the given memory block
	 * @return the index of the block, or -1 if the block is not in this list
	 */
	public int indexOf(MemoryBlock block) {
		Node temp= this.first;
		for(int i=0; i<size;i++){
			if(temp.block.equals(block)==true){
				return i-1;
			}
			temp=temp.next;
		}
		return -1;
	}

	/**
	 * Removes the given node from this list.	
	 * 
	 * @param node
	 *        the node that will be removed from this list
	 */
	public void remove(Node node) {
		Node temp= this.first;
		for(int i=0; i<size;i++){
			if(temp.next.block.equals(node.block)==true){
				temp.next=temp.next.next;
				size--;
				break;
			}
		}
	}

	/**
	 * Removes from this list the node which is located at the given index.
	 * 
	 * @param index the location of the node that has to be removed.
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than or equal to size
	 */
	public void remove(int index) {
		if(index<0 || index>= size){ 
			throw new IllegalArgumentException("Index is out of bounds"); }
	Node temp= this.first;
	for(int i=0; i<index;i++){
		temp=temp.next;
	}
	remove(temp);
	}
	/**
	 * Removes from this  list the node pointing to the given memory block.
	 * 
	 * @param block the memory block that should be removed from the list
	 * @throws IllegalArgumentException
	 *         if the given memory block is not in this list
	 */
	public void remove(MemoryBlock block) {
		Node temp= this.first;
		if(temp.next.block.equals(block)){
			this.first=temp.next;
			return;
		}
		for(int i=0;i<size-1;i++){
			if(temp.next.next.block.equals(block)){
				temp.next=temp.next.next;
				return;
				}
			}
			throw new IllegalArgumentException("Index is out of bounds");
		}
		

	/**
	 * Returns an iterator over this list, starting with the first element.
	 */
	public ListIterator iterator(){
		return new ListIterator(first);
	}
	
	/**
	 * A textual representation of this list, for debugging.
	 */
	public String toString() {
		Node temp= this.first;
		String list= "" + temp;
		for(int i=0;i<size-1;i++){
			temp=temp.next;
			list= list  + temp;
		}

		
		return list;
	}
}