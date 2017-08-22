require_relative 'error_panel'

class CheckoutPage
  include PageObject
  include DataMagic
  include ErrorPanel

  NAME_COLUMN = 1
  SUBTOTAL_COLUMN = 3
  LINES_PER_PUPPY = 6

  #DEFAULT_DATA = {
   #   'name' => 'cheezy',
   #  'address' => 'Almirante',
   #   'email' => 'cheezy@example.com',
   #   'pay_type' => 'Purchase order'
  #}

  DEFAULT_DATA = {
     'name' => Faker::Name.name,
     'address' => Faker::Address.street_address,
     'email' => Faker::Internet.email,
     'pay_type' => 'Credit card'
  }



  text_field(:name, :id => "order_name")
  text_area(:address, :id => "order_address")
  text_field(:email, :id => "order_email")
  select_list(:pay_type, :id => "order_pay_type")
  button(:place_order, :value => "Place Order")

  button(:proceed_to_checkout, :value => "Complete the Adoption")
  button(:continue_shopping, :value => "Adopt Another Puppy" )
  table(:cart, :index => 0)
  cell(:cart_total, :class => "total_cell")

  #div(:error_div, :id => 'error_explanation')
  #unordered_list(:error_messages) do |page|
   # page.error_div_element.unordered_list_element
  #end

  def initialize(browser)
    @browser = browser
  end

  def name=(name)
    @browser.text_field(:id => "order_name").set(name)
  end

  def address=(address)
    @browser.textarea(:id => "order_address").set(address)
  end

  def email=(email)
    @browser.text_field(:id => "order_email").set(email)
  end

  def pay_type=(pay_type)
    @browser.select_list(:id => "order_pay_type").select(pay_type)
  end

  def place_order
    @browser.button(:value => "Place Order").click
  end

  def name_for_line_item(line_item)
      table_value(line_item, NAME_COLUMN)
  end

  def subtotal_for_line_item(line_item)
      table_value(line_item, SUBTOTAL_COLUMN)
  end

  private def table_value(line_item, column)
      row = (line_item.to_i -1)*LINES_PER_PUPPY
      cart_element[row][column].text
  end

  def checkout1(data)
    self.name = data['name']
    self.address = data['address']
    self.email = data['email']
    self.pay_type = data['pay_type']
    place_order
  end

  def checkout2(data = {})
    data = DEFAULT_DATA.merge(data)
    self.name = data['name']
    self.address = data['address']
    self.email = data['email']
    self.pay_type = data['pay_type']
    place_order
  end

  #def checkout3(data = {})
   # populate_page_with(DEFAULT_DATA.merge(data))
   # place_order
  #end

  def checkout4(data = {})
    data = data_for(:checkout_page,data)
    self.name = data['name']
    self.address = data['address']
    self.email = data['email']
    self.pay_type = data['pay_type']
    place_order

  end


end