<?php include('components/head.php') ?>

<body>

    <div class="cursor"></div>

    <div class="homepage">

    <?php include('components/navbar.php') ?>

    </div>

    <div class="contact-header">
        <p class="contact-title1">Interested? <span>Let's talk !</span></p>
        <p class="contact-cta">You can fill out the form down below as accurately as possible and we will get back to
            you ASAP. Despise forms? Drop a mail at <a
                href="mailto: hello@oj-studiolive.com">oj.studiolive@outlook.com</a> or call us <a
                href="tel:+233-55-611-6488">+233 55 611 6488</a></p>
    </div>

    <?php include('components/contact-form.php') ?>

    <?php include('components/footer.php') ?>

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
    <script src="js/mailer.js"></script>
</body>

</html>