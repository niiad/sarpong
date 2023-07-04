<section class="contact">
    <div class="contact-container">
        <div class="form-image"><img src="./images/contact-form-vector.jpg" alt=""></div>
        
        <div class="contact-form">
            <p class="contact-title">DISCUSS YOUR PROJECT</p>
            <div class="container">
                <form onsubmit="SendEmail(); reset(); return false">
                    <input type="text" id="name" name="name" required placeholder="name">

                    <input type="text" id="email" name="email" required placeholder="your email">

                    <input type="tel" id="telephone" name="telephone" required
                        placeholder="your phone number, ex:+233 123456789">

                    <label class="subject" for="subject">How can we help ?</label>
                    <div name="subject" required>
                        <select name="subject" class="select" id="subject">
                            <option selected disabled>Choose a service</option>
                            <option value="Web Development">Web Development</option>
                            <option value="Development">Software Development</option>
                            <option value="App Dev">Mobile App Development</option>
                            <option value="UI/UX Design">UI/UX Design</option>
                            <option value="Facebook Ads">Facebook Ads</option>
                            <option value="Google Ads">Google Ads</option>
                            <option value="SEO">SEO Optimization</option>
                            <option value="Graphic Design">Graphic Design</option>
                            <option value="Photo/Video">Photography/ Videography</option>
                            <option value="Social Media Management">Social Media Management</option>
                            <option value="Technical Support">Technical Support</option>
                            <option value="Others">Others</option>
                        </select>
                        <span class="custom-arrow"></span>
                    </div>

                    <label class="budget" for="budget">What is your budget ?</label>
                    <div name="budget" required>
                        <select name="budget" class="second" id="budget">
                            <option selected disabled>Choose a budget</option>
                            <option value="Less than $1K">Less than $1K</option>
                            <option value="$1k - 5k">$1k - 5k</option>
                            <option value="$5k - 10">$5k - 10k</option>
                            <option value="$10k - 15k">$10k - 15k</option>
                            <option value="More than $15k">More than $15k</option>
                        </select>
                        <span class="custom-arrow"></span>
                    </div>

                    <textarea name="message" id="message" cols="30" rows="10" placeholder="your message" required></textarea>

                    <input type="submit" class="send-message-cta" value="SEND">

                </form>

            </div>
        </div>
    </div>

</section>