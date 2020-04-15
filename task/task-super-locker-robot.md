# TDD「super Locker Robot」
1. Given super robot has one locker when save and pick should return ticket and pick bag with the ticket.  
2. Given super robot has two lockers with same spaces rate when save should return ticket and pick bag from 1st locker. 
3. Given super robot has two lockers with same empty spaces different rate(2nd has little capacity) when save should return ticket 
   and pick bag from 2nd locker. 
4. Given super robot has two lockers with different spaces and 2nd has large space rate when save should return ticket 
   and pick bag with the ticket from 2nd one.
4. Given super robot has one full locker when save bag should throw exception.
5. Given super robot has one locker when pick with invalid ticket should throw exception.
6. Given super robot has one locker when pick with used ticket should throw exception.