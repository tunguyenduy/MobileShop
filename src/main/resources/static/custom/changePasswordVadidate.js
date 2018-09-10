function formValidation()
{
    var oldPassword = document.changePassword.oldPassword;
    var password = document.changePassword.newPassword;
    var repassword = document.changePassword.confirmPassword;
    if (oldPassword_validation(oldPassword))
    {
        if (password_validation(password, 5, 20))
        {
            if (repassword_validation(repassword, password))
            {
                
            }
        }
    }
    return false;

}
function oldPassword_validation(oldPassword)
{
    var uid_len = oldPassword.value.length;
    if (uid_len == 0)
    {
        swal("Thông báo","Không được để trống mật khẩu cũ");
        oldPassword.focus();
        return false;
    }
    return true;
}
function password_validation(password, mx, my)
{
    var passid_len = password.value.length;
    if (passid_len == 0 || passid_len >= my || passid_len < mx)
    {
        swal("Thông báo","Mật khẩu mới không được để trống và độ dài trong khoảng " + mx + " đến " + my);
        password.focus();
        return false;
    }
    return true;
}

function repassword_validation(password,repassword)
{
    if (password.value != repassword.value)
    {
        swal("Thông báo","Mật khẩu nhập lại không chính xác");
        repassword.focus();
        return false;
    } else{
        document.changePassword.action = "changePassword";
        document.changePassword.submit();
        return true;
    }
    
}


