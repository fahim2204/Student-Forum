<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Forum - Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer"
    />
</head>

<body>

    <div class="container rounded-4 bg-light mt-5 p-4 shadow " style="width: 500px">

        <h1 class=" text-secondary text-center fw-bold mb-5 ">Registration</h1>

        <form action=" " method="GET ">
            <!-- User name section -->
            <div class="mx-5 my-4 ">
                <label for="username " class="form-label fw-bold ">User Name/Email:</label>
                <div class="input-group">
                    <span class="input-group-text"> <i class="fas fa-user "></i></span>
                    <input type="text" class="form-control rounded-end " id="username " placeholder="Enter a Username ">
                    <div class="valid-feedback ">
                        Looks good!
                    </div>
                </div>
            </div>
            <!-- Password section -->
            <div class="mx-5 my-4 ">
                <label for="password " class="form-label fw-bold ">Password:</label>
                <div class="input-group ">
                    <span class="input-group-text "> <i class="fas fa-key "></i></span>
                    <input type="password" class="form-control rounded-end " id="password " placeholder="Enter a Password ">
                </div>
            </div>
            <!-- Confirm Password section -->
            <div class="mx-5 my-4">
                <label for="cpassword " class="form-label fw-bold ">Confirm Password:</label>
                <div class="input-group ">
                    <span class="input-group-text "> <i class="fas fa-key "></i></span>
                    <input type="password" class="form-control rounded-end " id="cpassword " placeholder="Confirm Password ">
                </div>
            </div>


            <!-- Registration -->
            <div class="d-flex justify-content-center my-2 ">
                <button type="submit " class="btn btn-lg btn-success px-sm-4 ">Register</button>
            </div>

            <div class="text-start mx-5 my-3 ">
                <a class="link-info " href="login">Already Registered?</a>
            </div>
            <!-- Registration with Oauth 2 -->
            <div class="text-center mx-5 my-3 ">
                <h6 class="text-muted ">Or, Register using</h5>
            </div>
            <div class="d-flex justify-content-center">
                <a href="#"><img class="mx-4 my-3" src="https://img.icons8.com/fluent/50/000000/google-logo.png" /></a>
                <a href="#"><img class="mx-4 my-3" src="https://img.icons8.com/color/50/000000/facebook-new.png" /></a>
            </div>






            <!-- <div class="container ">
                <div class="row ">
                    <div class="col-6 bg-secondary ">
                        hello
                    </div>
                    <div class="col-4 bg-danger ">hi</div>
                    <div class="col-2 bg-secondary ">hi</div>
                </div>
            </div> -->

        </form>


    </div>





























    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js " integrity="sha512-RXf+QSDCUQs5uwRKaDoXt55jygZZm2V++WUZduaU/Ui/9EGp3f/2KZVahFZBKGH0s774sd3HmrhUy+SgOFQLVQ==" crossorigin=" anonymous " referrerpolicy="no-referrer "></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js " integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p " crossorigin="anonymous "></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js " integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT " crossorigin="anonymous "></script>


</body>

</html>