Exploratory Testing - 


TC_1.1 - TC_1.5 -> (TC_1.2 /"Individual" - implemented in ExploratoryTesting Class)
i)SUMMARY/TITLE:  check that Sign Up form contains one radio button for each of the following labels "Education"/"Individual"/"Corporate"/"Partnership"/"Sole Trader"
ii)PRECONDITION:-
iii)STEPS/+TEST DATA: Open Sign Up Page
iv)EXPECTED RESULT: Sign Up Page should contain one radio button for each of the following labels "Education"/"Individual"/"Corporate"/"Partnership"/"Sole Trader"
v)ACTUAL RESULT: Sign Up Page contains one radio button for each of the following labels "Education"/"Individual"/"Corporate"/"Partnership"/"Sole Trader"


TC_2.1 - (implemented in ExploratoryTesting Class)
i)SUMMARY/TITLE: check that if no account type is selected the label of the first field is "Country"
ii)PRECONDITION:-
iii)STEPS/+TEST DATA: Open Sign Up Page; No account type is selected
iv)EXPECTED RESULT: The label of the first field should be "Country"
v)ACTUAL RESULT: The label of the first field is "Country"


TC_2.2
i)SUMMARY/TITLE: check that if "Individual" account type is selected the label of the first field changes to "Nationality"
ii)PRECONDITION: Open Sign Up Page
iIi)STEPS/+TEST DATA: 1)Select "Individual" account type
iv)EXPECTED RESULT: The label of the first field should be "Nationality"
v)ACTUAL RESULT: The label of the first field is "Nationality"

TC_2.3
i)SUMMARY/TITLE: check that if "Corporate"/"Partnership"/"Sole Trader" account type is selected the label of the first field changes to "Country of incorporation"
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 1)Select one of the following labels "Corporate"/"Partnership"/"Sole Trader" account type
iv)EXPECTED RESULT: The label of the first field should be "Country of incorporation"
v)ACTUAL RESULT: The label of the first field is "Country of incorporation"

TC_2.4
i)SUMMARY/TITLE: check that if "Education" account type is selected the label of the first field remains "Country"
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 1)Select "Education" account type
iv)EXPECTED RESULT: The label of the first field should be "Country"
v)ACTUAL RESULT: The label of the first field is "Country"


TC_3.1 - (implemented in ExploratoryTesting Class)
i)SUMMARY/TITLE: check that if user types a letter in the "Country" field the field will be populated with the first 
                 country that starts with that letter (No account type is selected)
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 1) Type a letter in the "Country" field
iv)EXPECTED RESULT: the field should be populated with the first country in the dropdown that starts with that letter
v)ACTUAL RESULT: The field is populated with the first country  in the dropdown  that starts with that letter

TC_3.2
i)SUMMARY/TITLE: check that if user starts typing in the "Country" field the field will be populated with the first
country matching the typed value and the respective country will be highlighted in the dropdown list
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 1)Type some text in the "Country" field, looking for a specific country
iv)EXPECTED RESULT: the field should be populated with the first country in the dropdown that matches the value and when unfolding 
                    the dropdown the country should be highlighted
v)ACTUAL RESULT: the field is populated with the first country in the dropdown that matches the value and when unfolding
                    the dropdown the country should be highlighted

TC_3.3
i)SUMMARY/TITLE: check that if user starts typing in the "Country" field characters that do not match the options in dropdown
the value existing on the country field does not change
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 1)Type some random characters in the "Country" field
iv)EXPECTED RESULT:  if typed characters do not match any option in dropdown, the value existing on the country field should not change
v)ACTUAL RESULT:  if typed characters do not match any option in dropdown, the value existing on the country field does not change

TC_4_1 
i)SUMMARY/TITLE: check if switching between fields using the Tab button on a keyboard works correctly on Sign Up page
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 1)Select first field and then use Tab to navigate
iv)EXPECTED RESULT: :All fields should be reachable using Tab
v)ACTUAL RESULT: All fields are reachable using Tab

TC_5.1
i)SUMMARY/TITLE: Check the validator of value on the field "First Name"; 
the "First Name" field should only accept letters and special characters: single apostrophe <'> and dash <-> 
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 
1) Select but do not fill the field "First Name" and click on any other field
2) Select but do not fill the field "First Name" then Click submit
3) Try to insert numbers instead of letters, then Click submit
4) Try to insert special characters instead of letters, then Click submit
5) Try to insert multiple spaces in the middle and before/after First Name, then Click submit
iv)EXPECTED RESULT: 
1) Correct/specific error message should appear above the field
2) Correct/specific error message should appear above the field 
3) Correct/specific error message should appear above the field  OR It should be impossible to fill or paste the field by numbers.
4) Correct/specific error message should appear above the field  OR It should be impossible to fill or paste special characters except for the single apostrophe <'> and the dash <->
5) The application should remove the unnecessary spaces
v)ACTUAL RESULT:
1) no error message is displayed above the field
2) error message: "Please enter correct information!" appears above the field
3) error message: "Please enter correct information!" appears above the field
4) error message: "Please enter correct information!" appears above the field
5) no error message; the application does not remove the unnecessary spaces

TC_5.2
i)SUMMARY/TITLE: Check the validator of length on the field "First Name" - the field supports a 
                      maximum length of 30 characters
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA:
1) fill the field "First Name" by 29 letters, then Click submit
2) fill the field "First Name" by 30 letters, then Click submit
3) fill the field "First Name" by 31 letters, then Click submit
4) fill the field "First Name" by 1 letter, then Click submit
iv)EXPECTED RESULT: 
1) no Error message should appear above the field; the name should be accepted
2) no Error message should appear above the field; the name should be accepted
3) the field should only "keep" the first 30 letters and a warning message should appear above the field about the maximum size accepted
4) Correct/specific error message should appear above the field
v)ACTUAL RESULT:
1) no Error message appears above the field; the name is accepted
2) no Error message appears above the field; the name is accepted
3) the field "keeps" the first 30 letters; no warning message appears above the field about the maximum size accepted
4) error message: "Please enter correct information!" appears above the field

TC_6.1
i)SUMMARY/TITLE: Check the validator of value on the field "Last Name"
                 the "Last Name" field should only accept letters and special characters: single apostrophe <'> and dash <->
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA:
1) Select but do not fill the field "Last Name" and click on any other field
2) Select but do not fill the field "Last Name" then Click submit
3) Try to insert numbers instead of letters, then Click submit
4) Try to insert special characters instead of letters, then Click submit
5) Try to insert multiple spaces in the middle and before/after "Last Name", then Click submit
   iv)EXPECTED RESULT:
1) Correct/specific error message should appear above the field
2) Correct/specific error message should appear above the field
3) Correct/specific error message should appear above the field  OR It should be impossible to fill or paste the field by numbers.
4) Correct/specific error message should appear above the field  OR It should be impossible to fill or paste special characters except for the single apostrophe <'> and the dash <->
5) The application should remove the unnecessary spaces
 v)ACTUAL RESULT:
1) no error message is displayed above the field
2) error message: "Please enter correct information!" appears above the field
3) error message: "Please enter correct information!" appears above the field
4) error message: "Please enter correct information!" appears above the field
5) no error message; the application does not remove the unnecessary spaces

TC_6.2
i)SUMMARY/TITLE: Check the validator of length on the field "Last Name" - the field supports a
                  maximum length of 30 characters
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA:
1) fill the field "Last Name" by 29 letters, then Click submit
2) fill the field "Last Name" by 30 letters, then Click submit
3) fill the field "Last Name" by 31 letters, then Click submit
4) fill the field "Last Name" by 1 letter, then Click submit
iv)EXPECTED RESULT:
1) no Error message should appear above the field; the name should be accepted
2) no Error message should appear above the field; the name should be accepted
3) the field should only "keep" the first 30 letters and a warning message should appear above the field about the maximum size accepted
4) Correct/specific error message should appear above the field
v)ACTUAL RESULT:
1) no Error message appears above the field; the name is accepted
2) no Error message appears above the field; the name is accepted
3) the field "keeps" the first 30 letters; no warning message appears above the field about the maximum size accepted
4) error message: "Please enter correct information!" appears above the field



TC_7.1  
i)SUMMARY/TITLE:  Check the validator of value on the field "Email"
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: 
1) Select but do not fill the field "Email" and click on any other field
2) Select but do not fill the field "Email" then Click submit
3) Try to insert only letters, then Click submit
4) Try to insert only numbers, then Click submit
5) Try to insert only special characters, then Click submit
6) Try to insert more than 1 @ in a valid email address (for example test67888@@yahoo.com), then Click submit
7) Try to insert multiple spaces before and/or after @ in a valid email address, then Click submit
8) Try to insert an email address with an invalid domain (for example test67888@@55656565o.555), then Click submit
9) Try to insert an email address with empty username, then Click submit
10) Try to insert an email address with empty domain, then Click submit
iv)EXPECTED RESULT:
1) No error message should appear above the field
2) Correct/specific error message should appear above the field: "The field is mandatory"
3) Correct/specific error message should appear above the field
4) Correct/specific error message should appear above the field
5) Correct/specific error message should appear above the field
6) Correct/specific error message should appear above the field
7) Correct/specific error message should appear above the field
8) Correct/specific error message should appear above the field
9) Correct/specific error message should appear above the field
10) Correct/specific error message should appear above the field
v)ACTUAL RESULT:
1) No error message appears above the field
2) Correct/specific error message appears above the field: "The field is mandatory"
3) error message: "Please enter correct information!" appears above the field
4) error message: "Please enter correct information!" appears above the field
5) error message: "Please enter correct information!" appears above the field
6) error message: "Please enter correct information!" appears above the field
7) error message: "Please enter correct information!" appears above the field
8) error message: "Please enter correct information!" appears above the field
9) error message: "Please enter correct information!" appears above the field
10)error message: "Please enter correct information!" appears above the field


TC_8.1  
i)SUMMARY/TITLE:  Check the validator of value on the field "Mobile Phone";
the "Mobile Phone" field should only accept numeric values/digits and special characters that will be removed after clicking submit dashes <->, parenthesis/round brackets <()>, spaces<   >
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA:
1) Select but do not fill the field "Mobile Phone" and click on any other field
2) Select but do not fill the field "Mobile Phone" then Click submit
3) Try to insert only letters, then Click submit
4) Try to insert only special characters, then Click submit
5) Verify that the "Mobile Phone" field allows the user to enter a mobile phone number with or without dashes <->, parenthesis/round brackets <()>, spaces<   >
   and after Clicking submit the application should remove the spaces, dashes, parenthesis/round brackets if any
iv)EXPECTED RESULT:
1) No error message should appear above the field
2) Correct/specific error message should appear above the field: "The field is mandatory"
3) Correct/specific error message should appear above the field
4) Correct/specific error message should appear above the field
5) user should be allowed to enter a mobile phone number with or without dashes <->, parenthesis/round brackets <()>, spaces<   >
   and after Clicking submit the application should remove the spaces, dashes, parenthesis/round brackets if any
v)ACTUAL RESULT:
1) No error message appears above the field
2) error message: "Please enter correct information!" appears above the field
3) error message: "Please enter correct information!" appears above the field
4) error message: "Please enter correct information!" appears above the field
5) user is allowed to enter a mobile phone number with or without dashes <->, parenthesis/round brackets <()>, spaces<   >
   and after Clicking submit the application removes the spaces, dashes, parenthesis/round brackets if any

TC_8.2
i)SUMMARY/TITLE: Check the validator of length on the field "Mobile Phone" - the field should support a
maximum length of 9 or 10 digits (details on length validation were not to be found when analyzing the web element in the DOM)
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA:
1) fill the field "Mobile Phone" by 1 digit, then Click submit
2) fill the field "Mobile Phone" by 2 digits, then Click submit
3) fill the field "Mobile Phone" by maximum accepted minus 1 digits, then Click submit
4) fill the field "Mobile Phone" by maximum accepted digits, then Click submit
5) fill the field "Mobile Phone" by more than maximum accepted digits, then Click submit
iv)EXPECTED RESULT:
1) Correct/specific error message should appear above the field
2) Correct/specific error message should appear above the field
3) Correct/specific error message should appear above the field
4) the phone number should be accepted
5) Correct/specific error message should appear above the field
v)ACTUAL RESULT:
1) error message: "Please enter correct information!" appears above the field
2) no error message appears above the field; the digits are accepted as phone number
3) no error message appears above the field; the digits are accepted as phone number
4) the phone number is accepted
5) no error message appears above the field; the digits are accepted as phone number (the field accepts around 45 digits)


TC_9_1 - (detailed test case  -> signUpFeature)
i)SUMMARY/TITLE: Successful account registration, user is navigated to Email And Mobile Number Verification Page
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: User fills in all required user data and checks all checkboxes
iv)EXPECTED RESULT: User should be registered and navigated to Email And Mobile Number Verification Page
v)ACTUAL RESULT: User is registered and navigated to Email And Mobile Number Verification Page

TC_9.2 - (detailed test case -> signUpFeature)
i)SUMMARY/TITLE:  (Verify) user cannot proceed on Email And Mobile Number Verification Page by utilizing
an already used "Email" address
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: User fills in all required user data, utilizing an already used "Email" address
iv)EXPECTED RESULT: -Correct error message should appear above the "Email" field: "Already exists!";
-User remains on Sign Up Page
v)ACTUAL RESULT: -Correct error message appears above the "Email" field: "Already exists!";
-User remains on Sign Up Page

TC_9.3 - (detailed test case -> signUpFeature)
i)SUMMARY/TITLE:  (Verify) user cannot proceed on Email And Mobile Number Verification Page by utilizing
an already used "Mobile Phone" number
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: User fills in all required user data, utilizing an already used "Mobile Phone" number
iv)EXPECTED RESULT: -Correct error message should appear above the field "Mobile Phone": "Already exists!";
                    -User remains on Sign Up Page
v)ACTUAL RESULT: User is registered and navigated to Email And Mobile Number Verification Page


TC_9_4 - (detailed test case  -> signUpFeature)
i)SUMMARY/TITLE: (Verify) user cannot proceed on Email And Mobile Number Verification Page
without checking the Terms of Use and Privacy Policy checkbox
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: User fills in all required user data, without checking the Terms of Use and Privacy Policy checkbox
iv)EXPECTED RESULT: -Correct error message should appear above the Terms of Use and Privacy Policy checkbox:
"Click OK to return and check the box that you have read and agree with our Terms of Use";
                    -User should remain on Sign Up Page
v)ACTUAL RESULT:-Correct error message appears above the Terms of Use and Privacy Policy checkbox: "Click OK to return and check the box that you have read and agree with our Terms of Use";
                -User remains on Sign Up Page

TC_9_5 - (detailed test case  -> signUpFeature)
i)SUMMARY/TITLE: (Verify) user can proceed on Email And Mobile Number Verification Page
without checking the News and Offers checkbox
ii)PRECONDITION: Open Sign Up Page
iii)STEPS/+TEST DATA: User fills in all required user data, checking the Terms of Use and Privacy Policy checkbox,
without checking the News and Offers checkbox
iv)EXPECTED RESULT: User should be registered and  navigated to Email And Mobile Number Verification Page
v)ACTUAL RESULT:User is registered and redirected to Email And Mobile Number Verification Page

