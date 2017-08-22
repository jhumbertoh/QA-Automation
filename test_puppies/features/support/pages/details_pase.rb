class DetailsPage
  include PageObject

  button(:add_to_cart,:value => 'Adopt Me!')

  def add_to_cart
    @browser.button(:value => 'Adopt Me!').click
  end
end
