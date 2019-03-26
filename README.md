# infixTother
*THIS PROJECT IS UNDER DEVELOPMENT.*  
**infixTother** is a simple app that convert infix expression to postfix/prefix expression.  
- [Limitation?](https://github.com/RxnNode/infixTother#limitation-)
- [To Do list](https://github.com/RxnNode/infixTother#to-do-list-)
- [Downloads](https://github.com/RxnNode/infixTother#downloads-)

## Limitation? [↑](https://github.com/RxnNode/infixTother#infixtother)
1. One digit per terms  
    It can convert a expression that ONLY contains ONE-DIGIT terms.  
    For example :  
    >1+(2*3-(4/5^2)*7) is convertible.  
    >12 +( 21 *3-(4/ 54 ^2)*7) is not convertible.
    This limitation may be fixed in future.
2. Well-formed expressions  
    For example :  
    >1+(2*3-(4/5^2)*7) is well-formed.   
    >*1+3/-3 is not well-formed.   
    *Please avoid negative number in the begining of expression.*

## Downloads [↑](https://github.com/RxnNode/infixTother#infixtother)
[infixTother v1.0](https://github.com/RxnNode/infixTother/releases)
## Test result
1. 1+(2*3-(4/5^2)*7)
![1+(2*3-(4/5^2)*7)](/images/test01.png)
2. 4^2*3-3+8/4/(1+1)
![4^2*3-3+8/4/(1+1)](/images/test02.png)
3. 1+(2*3-(4/2*2)*7)
![1+(2*3-(4/2*2)*7)](/images/test03.png)

## To Do list [↑](https://github.com/RxnNode/infixTother#infixtother)
- [ ] KILL Limitation 1.  
- [ ] Auto checking for Limitation 2.   
