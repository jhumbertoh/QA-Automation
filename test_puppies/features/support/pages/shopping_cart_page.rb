class ShoppingCartPage
  include PageObject

  NAME_COLUMN = 1
  SUBTOTAL_COLUMN = 3
  LINES_PER_PUPPY = 6

  button(:proceed_to_checkout, :value => "Complete the Adoption")
  button(:continue_shopping, :value => "Adopt Another Puppy")
  table(:cart, :index =>0)
  cell(:cart_total, :class => "total_cell")


  def initialize(browser)
    @browser = browser
  end

  #@cart = ShoppingCartPage.new(@browser)

  def name_for_line_item(line_item)
     cart_line_item(line_item)[NAME_COLUMN].text
    #table_value(line_item, NAME_COLUMN)
  end

  def subtotal_for_line_item(line_item)
    cart_line_item(line_item)[3].text
    #table_value(line_item, SUBTOTAL_COLUMN)
  end

  def cart_total
    @browser.td(:class => 'total_cell').text
  end

  private def row_for(line_item)
  (line_item - 1)*6
  end

  def cart_line_item(line_item)
    @browser.table(:index => 0)[row_for(line_item)]
  end

  def proceed_to_checkout
    @browser.button(:value => 'Complete the Adoption').click
  end

  def continue_shopping
    @browser.button(:value => 'Adopt Another Puppy').click
  end

  private def table_value(line_item, column)
    row = (line_item.to_i - 1)*LINES_PER_PUPPY
    cart_element(row)[column].text
  end

  #def cart_element(row)
  #  @browser.table(:index => 0)[row_for(row)]
  #end

  #cart_line_item(line_item)[3].text

end


