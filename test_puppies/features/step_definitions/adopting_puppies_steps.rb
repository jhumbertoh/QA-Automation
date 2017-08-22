Given(/^I am on the puppy adoption site$/) do
  @browser.goto "http://puppies.herokuapp.com"
  @home = HomePage.new(@browser)
end

When(/^I click the View Details button$/) do
  @browser.button(:value => "View Details").click
end


And(/^I click the Adopt Me button$/) do
  @details.add_to_cart
  @cart = ShoppingCartPage.new(@browser)
  #@browser.button(:value => "Adopt Me!").click
end


And(/^I click the Complete the Adoption button$/) do
  #@browser.button(:value => "Complete the Adoption").click
  @cart.proceed_to_checkout 
  @checkout = CheckoutPage.new(@browser)
end

And(/^I enter "([^"]*)" in the name field$/) do |name|
  #@browser.text_field(:id => "order_name").set(name)
  @checkout.name = name
end

And(/^I enter "([^"]*)" in the address field$/) do |address|
  #@browser.textarea(:id => "order_address").set(address)
  @checkout.address = address
end

And(/^I enter "([^"]*)" in the email field$/) do |email|
  #@browser.text_field(:id => "order_email").set(email)
  @checkout.email = email
end

And(/^I select "([^"]*)" from the pay with dropdown$/) do |pay_type|
  #@browser.select_list(:id => "order_pay_type").select(pay_type)
  @checkout.pay_type = pay_type
end

And(/^I click the Place Order button$/) do
  #@browser.button(:value => "Place Order").click
  @checkout.place_order
end

Then(/^I should see "([^"]*)"$/) do |expected|
  @browser.text.should include expected
end

And(/^I click the Adopt Another Puppy button$/) do
  #@browser.button(:value => "Adopt Another Puppy").click
  @cart.continue_shopping
end

#And(/^I click the second View Details button$/) do
#   @browser.button(:xpath => "//DIV[@id='content']//*[text()='Hanna']//parent::div//parent::div//parent::div/input").click
#end

And(/^I click the View Details button of the Puppy "([^"]*)"$/) do |puppy_name|
  #@browser.button(:xpath => "//DIV[@id='content']//*[text()='"+puppy_name+"']//parent::div/following-sibling::div[@class='view']//input").click
  @home.puppy_name = puppy_name
  @details = DetailsPage.new(@browser)
end

When(/^I click the first View Details button$/) do
  @browser.button(:value => "View Details").click

end

Then(/^I should see "([^"]*)" as the name for line item (\d+)$/) do |name, line_item|
  #cart_line_item(line_item.to_i)[1].text.should include name
  @cart.name_for_line_item(line_item.to_i).should include name
end

def row_for(line_item)
  (line_item-1)*6
end

def cart_line_item(line_item)
  @browser.table(:index => 0)[row_for(line_item)]
end

And(/^I should see "([^"]*)" as the subtotal for line item (\d+)$/) do |subtotal, line_item|
  #cart_line_item(line_item.to_i)[3].text.should == subtotal
  @cart.subtotal_for_line_item(line_item.to_i).should == subtotal
end

And(/^I should see "([^"]*)" as the cart total$/) do |total|
  #@browser.td(:class => 'total_cell').text.should == total
  @cart.cart_total.should == total
end


And(/^I complete the adoption with:$/) do |table|
 # on(CheckoutPage).checkout(table.hashes.first)
  @checkout.checkout1(table.hashes.first)
end

When(/^I complete the adoption of a puppy$/) do
  data = {}
  @checkout.checkout4(data)
end

And(/^I checkout leaving the name field blank$/) do
  @checkout.name = ''
  @checkout.place_order
end

Then(/^I should see the error message "([^"]*)"$/) do |msg|
 @checkout.error_messages.should include msg
  #on(CheckoutPage).error_messages.should include msg
end