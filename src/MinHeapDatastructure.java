
public class MinHeapDatastructure {

	public static void main(String[] args) {

		//HeapStruct minHeap = new HeapStruct(4);

		HeapStruct minHeap = new HeapStruct(15);
		minHeap.insert(2);
		minHeap.insert(21);
		minHeap.insert(0);
		minHeap.insert(3);
		minHeap.insert(12);
		minHeap.minHeap();

		minHeap.print();

		int size = minHeap.size;
		while (size > 0) {
			System.out.println(minHeap.popMinHeap());
			size--;
		}

	}
	
	static class HeapStruct {
		private int[] heap;
		int maxSize;
		int size;
		private static final int FIRST = 1;

		HeapStruct(int maxSize) {
			this.maxSize = maxSize;
			this.heap = new int[maxSize+1];
			this.heap[0] = Integer.MIN_VALUE;
		}
		
		private int parent(int pos) {
			return pos/2;
		}
		
		private int leftNode(int pos) {
			return pos*2;
		}
		
		private int rightNode(int pos) {
			return (pos*2)+1;
		}
		
		private boolean isLeaf(int pos) {
			if(pos >= size/2 &&  pos <= size) {
				return true;
			}
			return false;
		}
		
		private void minHeapify(int pos) {
			if(!isLeaf(pos)) {
				 if(heap[pos] > heap[leftNode(pos)] || heap[pos] > heap[rightNode(pos)]) {

					if (heap[leftNode(pos)] < heap[rightNode(pos)]) {
						swap(pos, leftNode(pos));
						minHeapify(leftNode(pos));
					} else {
						swap(pos, rightNode(pos));
						minHeapify(rightNode(pos));
					}

				}
				
			}
		}
		
		public void minHeap() {
			for(int pos = (size/2); pos>=1;pos--) {
				minHeapify(pos);
			}
		}
		
		public void insert(int data) {
			heap[++size] = data;
			int current = size;
			while(heap[current] < heap[parent(current)]) {
				swap(current,parent(current));
				current = parent(current);
			}
		}
		
		public Integer getMinHeap() {
			return heap[FIRST];
		}
		
		public Integer popMinHeap() {
			
			int popped = heap[FIRST];
			heap[FIRST] = heap[size]; 
			heap[size] = 0;
			size--;
	        minHeapify(FIRST);
	        return popped;
		}
		
		public void print()
	    {
	        for (int i = 1; i <= size / 2; i++ )
	        {
	            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i] 
	                + " RIGHT CHILD :" + heap[2 * i  + 1]);
	            System.out.println();
	        } 
	    }
		
		private void swap(int pos, int spos) {
			int temp = heap[pos];
			heap[pos] = heap[spos];
			heap[spos] = temp;
		}
		
	}

}
