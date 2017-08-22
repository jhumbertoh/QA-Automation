class HomePage
    include PageObject

    button(:puppy_name)


    def puppy_name=(puppy_name)

      @browser.button(:xpath => "//DIV[@id='content']//*[text()='"+puppy_name+"']//parent::div/following-sibling::div[@class='view']//input").click

    end

end