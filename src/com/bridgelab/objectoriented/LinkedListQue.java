package com.bridgelab.objectoriented;

public class LinkedListQue {
	CardNode FRONT;
	CardNode REAR;
	
	public boolean isEmpty() {
		return FRONT == null;
	}

	public void add(CardNode newNode) {
		if (isEmpty()) {
			FRONT = newNode;
			REAR = newNode;
		} else {
			REAR.next = newNode;
			REAR=newNode;
		}
	}

	public CardNode remove() {
		CardNode temp = FRONT;
		FRONT = FRONT.next;
		return temp;
	}

	public void show() {
		CardNode temp = FRONT;
		int k=1;
		for (int i = 0; i < 36; i++) {
			if (i % 9 == 0)
				System.out.println("******\nPlayer :" + k++);

			System.out.println(temp.suit + ": " + temp.rank);
			temp=temp.next;
		}
	}

	public void sort() {
		CardNode start = FRONT;
		CardNode end = FRONT;
		int z = 0;
		int k = 0;
		
		while (k < 4) {
			z=0;
			while (z < 8) {
				end = end.next;
				z++;
			}
			String rank;
			String suit;
			while (start != end) {
				for (CardNode j = start; j != end.next; j = j.next) {
					if (j.rank.compareTo(j.next.rank)< 0) {
						 rank= j.rank;
						 suit=j.suit;
						j.rank = j.next.rank;
						j.suit=j.next.suit;
						j.next.rank = rank;
						j.next.suit=suit;
						
					}
				}
				start = start.next;
			}
			k++;
		}
		k=0;
		CardNode temp=FRONT;
		while(k<4)
		{
			System.out.println("\n=======Player "+k);
			for(int i=0;i<9;i++)
			{
				System.out.println(temp.suit+ " "+temp.rank);
				temp=temp.next;
			}
			k++;
		}
	}

}
