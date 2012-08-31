from Purchaseorder as po 
inner join fetch po.customer as cust
inner join fetch po.orderdetails as order_details
inner join fetch order_details.product as product
where cust.customernumber = :cust_num
order by po.orderdate, 
order_details.orderlinenumber 
 