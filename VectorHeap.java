import java.util.Vector;

/** 
* Jorge Mario Tezen 15417
 * @param <E>
*/

//Clase tomada de los ejemplos

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
	
	protected Vector<E> data;
	
	public VectorHeap(){
		//post: constructs a new priority queue
		data = new Vector<E>();
	}
	
	public VectorHeap(Vector<E> v){
		//post:constructs a new priority queue from an unordered vector
		int i;
		data = new Vector<E>(v.size()); //we know ultimate size
		for(i=0; i<v.size(); i++){
			//add elements to heap
			add(v.get(i));
		}
	}
	
	/**
	*Returns parent of node at location i
     * @param i
     * @return 
	*/
	protected static int parent(int i){
		//pre: 0<=i<size
		//post: returns parent of node at location i
		return (i-1)/2;
	}
	
	/**
	*Returns index of left child of node at location i
     * @param i
     * @return 
	*/
	protected static int left(int i){
		//pre: 0<=i<size
		//post: returns index of left child of note at location i
		return 2*i+1;
	}
	
	/**
	*Returns index of right child of node at location i
     * @param i
     * @return 
	*/
	protected static int right(int i){
		//pre: 0<=i<size
		//post: returns index of right child of node at location i
		return 2*(i+1);
	}
	
	
	
	//Metodos para mover los nodos
	protected void percolateUp(int leaf){
		//pre: 0<=leaf<size
		//post: moves node at index lead up to appropiate position
		int parent = parent(leaf);
		E value = data.get(leaf);
		//Aqui se compara el codigo ASCII
		while(leaf>0 &&
				(value.compareTo(data.get(parent))<0)){
			data.set(leaf, data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}
	
	/**
	*Moves node at index root down to appropiate position in subtree
     * @param root
	*/
	protected void pushDownRoot(int root){
		//pre: 0<=root<size
		//post: moves node at index root down to appropiate position in subtree
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) 
		{
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) && ((data.get(childpos+1)).compareTo (data.get(childpos)) < 0))
				{
					childpos++;
				}
				// Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo (value) < 0)
				{
					data.set(root,data.get(childpos));
					root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}
	
	
	@Override
	public E getFirst() {
		//pre: !isEmpty()
		//post: returns the minimum value in priority queue
		return data.get(0);
	}

	@Override
	public E remove() {
		//pre: !isEmpty()
		//post: removes and returns the minimum value in priority queue
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if(data.size()>1){pushDownRoot(0);};
		return minVal;
	}

	@Override
	public void add(E value) {
		//pre: value is non-null comparable
		//post: value is added to priority queue
		data.add(value);
		percolateUp(data.size()-1);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
