package com.javaCoreAssessment.CustomLinkedList;

import com.javaCoreAssessment.model.Task;

public class Node
{
    public Task data;
    public Node next;

    public Node(Task data)
    {
        this.data = data;
        this.next = null;
    }
}
