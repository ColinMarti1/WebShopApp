import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="bg-gray-800 p-4 text-white">
      <div className="container mx-auto flex justify-between items-center">
        <Link to="/" className="text-2xl font-bold">Shop</Link>
        <div className="flex space-x-4">
          <Link to="/cart">Warenkorb</Link>
          <Link to="/checkout">Checkout</Link>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
