# Test Driven Development Implementation
-
-
                                        Red -> Green -> Refactor -> Repeat
-
-
Several unit tests are written first for createUser method. 
The wrongs in the unit tests are fixed line by line by implementing the method, 
making the red turn to green for each step and finally the unit tests are passed.

The redundancy is handled by merging unit test methods where necessary and by using lifecycle methods.

Unit test method names:

teatCreateUser_whenUserDetailsProvided_returnUserProject
testCreateMethod_whenFirstNameIsEmpty_throwsIllegelArgumentException
testCreateMethod_whenLastNameIsEmpty_throwIllegalArgumentException
testCreateMethod_whenEmailIsEmpty_throwIllegalArgumentException
testCreateMethod_whenPasswordAndConfirmNotSame_returnUserObject
testCreateMethod_whenPasswordNotAlphanumeric_returnUserObject
testCreateMethod_whenPassswordNotEnoughLength_returuenUserObject

