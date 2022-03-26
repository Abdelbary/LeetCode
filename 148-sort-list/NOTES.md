{
if(current == null)
{
current = new ListNode(left.val);
tmp = current;
}else{
current.next = new ListNode(left.val);
current = current.next;
}
left = left.next;
}
while(right != null)
{
if(current == null)
{
current = new ListNode(right.val);
tmp = current;
}else{
current.next =new ListNode(right.val);
current = current.next;
}
right = right.next;
}
current.next = null;
return tmp;
}
}
```