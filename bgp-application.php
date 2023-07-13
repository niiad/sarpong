<?php include('components/head.php')?>

<body>
    <div class="cursor"></div>

    <div class="homepage">

    <?php include('components/navbar.php')?>

    </div>

    <div
        <p class="application-header">APPLY FOR<span> THE BUSINESS GROWTH PROGRAM</span></p>
    </div>

    <section class="application">
        <div class="application-container">
            <div class="form-image"><img src="./images/application-form-vector.jpg" alt=""></div>

            <div class="application-form">
                <p class="application-title">FILL OUT THE FORM</p>
                <div class="container">

                    <form onsubmit="SendEmail(); reset(); return false">

                        <input type="text" id="fullname" name="fullname" required placeholder="full name">

                        <input type="text" id="email" name="email" required placeholder="your email">
                        
                        <input type="tel" id="telephone" name="telephone" required placeholder="your phone number">

                        <input type="text" id="businessname" name="businessname" required placeholder="your business' name">

                        <label for="goal" class="goal">What is your goal?</label>
                        <select name="goal" class="goal" id="goal">
                            <option selected disabled>I want to achieve</option>
                            <option value="Development">Website/ Software Development</option>
                            <option value="App Dev">Mobile App Development</option>
                        </select>
                        <span class="custom-arrow"></span>

                        <textarea name="message" id="message" cols="30" rows="10" placeholder="your message" required></textarea>

                        <input type="submit" class="send-docs-cta" value="SEND">

                    </form>
                </div>
            </div>
        </div>
    </section>

   
    <?php include('components/footer.php')?>

    <script src="./js/main.js"></script>

    <script>
        const mobileBtn = document.getElementById('mobile-cta')
              nav = document.querySelector('nav')
              mobileBtnExit = document.getElementById('menuclose')
        
        mobileBtn.addEventListener('click', () => {
            nav.classList.add('mobile-menu');
        })
        
        mobileBtnExit.addEventListener('click', () => {
            nav.classList.remove('mobile-menu');
        })
    </script>

    <script src="https://smtpjs.com/v3/smtp.js"></script>
    <script src="js/application-mailer.js"></script>
    
</body>

</html>