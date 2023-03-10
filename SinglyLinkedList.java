package com.singlylinkedlist;

public class SinglyLinkedList {

	private static   ListNode head;
	private static class ListNode 
	{
		private int data;
		private ListNode next;

		public ListNode(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	public void display()
	{
		// Traverse and Print All Nodes By Using while loop because Don't known Ending points
		ListNode current = head;
		while(current!=null)
		{
			System.out.print(current.data+"---->");
			current = current.next;
			break;
		}

		System.out.print("null");

	}

	public static ListNode findMid()
	{   
		ListNode sloprt = head;
		ListNode fasprt = head;
		while(fasprt!=null && sloprt.next!=null)
		{
			sloprt=sloprt.next;
			fasprt = fasprt.next.next;
		}
		return sloprt;
	}

	public ListNode findnthpos(int position)
	{
		if(head==null)
		{
			return null;
		}

		if(position <=0)
		{
			throw new IllegalArgumentException("Enter valid length");
		}
		ListNode mainptr = head;
		ListNode subptr = head;
		int count=0;
		while(count<position)
		{
			count++;
			subptr=subptr.next;
		}
		while(subptr!=null)
		{
			subptr = subptr.next;
			mainptr=mainptr.next;
		}
		return mainptr;
	}

	public void removeDuplicate()
	{
		ListNode current = head;
		while(current!=null&& current.next!=null)
		{
			if(current.data==current.next.data)
			{
				current.next = current.next.next;
			}
			else {
				current=current.next;
			}
		}
	}
	public ListNode insertValueInSorted(int value)
	{
		ListNode newNode = new ListNode(value);
		ListNode current = head;
		ListNode temp = null;
		while(current!=null&& current.data<newNode.data )
		{
			temp=current;
			current = current.next;
		}
		temp.next=newNode;
		newNode.next=current;
		return head;
	}
	public int removeKeyValue(int value)
	{
		ListNode temp = null;
		ListNode current = head;
		while(current!=null&&current.data!=value)
		{
			temp = current;
			current = current.next;
		}
		if(current.data==value) {
			temp.next=current.next;
		}
		return current.data;
	}
	public boolean checkLoop()
	{
		ListNode fastptr = head;
		ListNode slowptr = head;
		while(fastptr!=null && fastptr.next!=null)
		{
			fastptr=fastptr.next.next;
			slowptr=slowptr.next;
			if(fastptr==slowptr)
			{
				return true;
			}

		}
		return false;

	}
	public int findStartNode()
	{
		ListNode fastptr = head;
		ListNode slowptr = head;
		while(fastptr!=null && fastptr.next!=null)
		{
			fastptr=fastptr.next.next;
			slowptr=slowptr.next;
			if(fastptr==slowptr)
			{
				return  getFirstNode(slowptr) ;
			}

		}
		return 0;
	}
	public int getFirstNode(ListNode slowptr)
	{
		ListNode temp = head;
		while(temp!=slowptr)
		{
			temp = temp.next;
			slowptr=slowptr.next;
		}
		return temp.data;


	}
	public static void main(String[] args) {
		// Create Instance because accessing head
		SinglyLinkedList s = new SinglyLinkedList();
		s.head = new ListNode(10);
		ListNode second = new ListNode(20);
		ListNode third = new ListNode(30);
		ListNode fourth = new ListNode(40);
		ListNode fifth = new ListNode(50);
		s.head.next=second;// 10--->10
		second.next = third;// 10--->30
		third.next = fourth;// 30--->20
		fourth.next=fifth; // 20---->30
		fifth.next=second;
		//s.display();
		//		System.out.println();
		//		//System.out.println(SinglyLinkedList.findMid().data);
		//
		//		ListNode node = s.findnthpos(2);
		//		System.out.println("take value from end ");
		//		System.out.println(node.data);
		//
		//		System.out.println("remove duplicate node");
		//		s.removeDuplicate();
		//		s.display();
		//
		//		System.out.println("Insert value in sorted order");System.out.println();
		//		s.insertValueInSorted(40);
		//		s.display();
		//		
		//		System.out.println("Remove based kay value");
		//		System.out.println("this node will be removed "+s.removeKeyValue(50));
		//		System.out.println("this node will be removed "+s.removeKeyValue(30));
		//		s.display();

		System.out.println();
		System.out.println("Find If the Node is loop or not");
		System.out.println(s.checkLoop());

		System.out.println("How to find loop started node");
		System.out.println(s.findStartNode());
		s.display();


	}

}
