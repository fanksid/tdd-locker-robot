# TDD「Smart Locker Robot」
1. Given smart robot has one locker when save and pick should return ticket and pick bag with the ticket.  
2. Given smart robot has two lockers with same spaces when save should return ticket and pick bag from first locker. 
3. Given smart robot has two lockers with different spaces when save should return ticket and pick bag with the 
   ticket from locker of more spaces.
4. Given smart robot has one full locker when save bag should throw exception.
5. Given smart robot has one locker when pick with invalid ticket should throw exception.
6. Given smart robot has one locker when pick with used ticket should throw exception.