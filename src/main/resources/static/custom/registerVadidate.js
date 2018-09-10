function formValidation()
{
    var username = document.registration.username;
    var password = document.registration.password;
    var repassword = document.registration.repassword;
    var fullname = document.registration.fullname;
    var address = document.registration.address;
    var phonenum = document.registration.phoneNum;
    var email = document.registration.email;
    if (username_validation(username, 5, 20))
    {
        if (password_validation(password, 5, 20))
        {
            if (repassword_validation(repassword, password))
            {
                if (allLetter(fullname))
                {
                    if (allLetter1(address))
                    {
                        if (allnumeric(phonenum))
                        {
                            if (ValidateEmail(email))
                            {

                            }
                        }
                    }
                }
            }
        }
    }
    return false;
	

}
function username_validation(username, mx, my)
{
    var uid_len = username.value.length;
    if (uid_len == 0 || uid_len >= my || uid_len < mx)
    {
        swal("Notification","Username must be not empty and length in range from  " + mx + " to " + my);
        username.focus();
        return false;
    }
    return true;
}
function password_validation(password, mx, my)
{
    var passid_len = password.value.length;
    if (passid_len == 0 || passid_len >= my || passid_len < mx)
    {
        swal("Notification","Password must be not empty and length in range from  " + mx + " to " + my);
        password.focus();
        return false;
    }
    return true;
}

function repassword_validation(password,repassword)
{
    if (password.value != repassword.value)
    {
        swal("Notification","Password confirm is not correct!");
        repassword.focus();
        return false;
    }
    return true;
}

function allLetter(fullname)
{
    var letters = /^[A-Za-z]+$/;
    if (fullname.value.length !=0)
    {
        return true;
    } else
    {
        swal('Notification','Full name field must be not empty!');
        fullname.focus();
        return false;
    }
}

function allLetter1(address)
{
    var letters = /^[A-Za-z]+$/;
    if (address.value.length !=0)
    {
        return true;
    } else
    {
        swal('Notification','Address field must be not empty!');
        address.focus();
        return false;
    }
}

function allnumeric(phonenum)
{
    var numbers = /^[0-9]+$/;
    if (phonenum.value.match(numbers))
    {
        return true;
    } else
    {
        swal('Notification','Phone number must contain character 0-9');
        phonenum.focus();
        return false;
    }
}
function ValidateEmail(email)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (email.value.match(mailformat))
    {
        document.registration.action = "localhost:8080/client/login";
        document.registration.submit();
        return true;
    } else
    {
        swal('Notification','Email form is not correct!');
        return false;
    }
}


