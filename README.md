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

testCreateUser_whenUserDetailsProvided_returnUserProject
testCreateUser_whenFirstNameIsEmpty_throwsIllegelArgumentException
testCreateUser_whenLastNameIsEmpty_throwIllegalArgumentException
testCreateUser_whenEmailIsEmpty_throwIllegalArgumentException
testCreateUser_whenPasswordAndConfirmNotSame_returnUserObject
testCreateUser_whenPasswordNotAlphanumeric_returnUserObject
testCreateUser_whenPassswordNotEnoughLength_returuenUserObject

Mockito is used to create test double objects(usersRepository) in the test class.

