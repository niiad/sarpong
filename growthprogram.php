<?php include('components/head.php')?>

<body>
    <div class="cursor"></div>

    <div class="homepage">

    <?php include('components/navbar.php')?>

    </div>
    
<section class="growth-program">
    <div class="container">
        <div class="info">
            <p class="info-title">THE BUSINESS GROWTH PROGRAM</p>

            <P class="info-slogan">EVOLUTION-INVESTMENT-COOPERATION</P>

            <p class="info-text">The Business Growth Program was implemented this year by OJ StudioLive in the hope of encouraging small businesses to digitalize their businesses and to eventually grow larger than they currently are. Our goal is also to push young entrepreneurs and to invest in them. The program will allow its beneficiators to start their projects as soon as their application is reviewed and approved with a discount of their project from 30-60%* and a minimum deposit of 0-20%*.</p>

            <p class="attention">*may vary according to applicants</p>

        </div>

        <div class="conditions">
            <p class="conditions-title">Conditions To Apply</p>
            <p class="conditions-text">In order to apply or benefit from the Business Growth Program, applicants must be at least 16 years old and must have a +1 year old registered business.
                The applicants must fill out the form linked down below and submit a business plan for their business as well as provide a revenue report from the current or previous year if current year hasn't approached its end (in our case, September-January). Note that all documents must be specified as followed docname-businessname (doc name being businessplan or revenuereport for example) for recognition purposes or should all be uploaded to a folder named after your business and should all be converted to a pdf format before upload.
                Applicants are deserving of privacy and the protection of their information and so, are provided with a NDA available to download <a href="/doc/BUSINESS GROWTH PROGRAM NDA.pdf" download="">here</a> which must be filled and submitted as well. Check for email confirmation after submission.</p>
        </div>

        <div class="application-approval">
            <p class="approval-title">Upon Approval of Application</p>
            <p class="approval-text">After approval of application, an interview will be conducted by our CEO to get to know the applicants and discuss details after which a contract will be drawn in 2-5 business days stating all the information necessary to conduct the applicant's project successfully. Project will immediately start after signature of the contract by the two parties.</p>
            <center>
            <a href="bgp-application.php" class="apply-button">APPLY HERE</a>
            </center>
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
    
</body>

</html>