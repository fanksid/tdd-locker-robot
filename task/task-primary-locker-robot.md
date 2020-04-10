# TDD「Locker Robot」
1. Given robot has one locker when save and pick robot should return ticket and pick bag with the ticket.   
2. Given robot has two empty lockers when save robot should return ticket and pick bag from first locker.  
3. Given robot has two lockers and 1st full when save robot should return ticket and pick bag with the ticket from 2nd.
4. Given robot has one full locker when save bag robot should throw exception.
5. Given robot has one locker when pick with invalid ticket robot should throw exception.
6. Given robot has one locker when pick with used ticket robot should throw exception.