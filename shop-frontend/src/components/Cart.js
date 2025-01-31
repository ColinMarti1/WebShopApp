import { useState, useEffect } from "react";

function Cart() {
  const [cart, setCart] = useState([]);

  useEffect(() => {
    // Hier könnte man den Warenkorb aus dem lokalen Speicher oder einer API laden
    const savedCart = JSON.parse(localStorage.getItem("cart")) || [];
    setCart(savedCart);
  }, []);

  const removeFromCart = (productId) => {
    const updatedCart = cart.filter(item => item.id !== productId);
    setCart(updatedCart);
    localStorage.setItem("cart", JSON.stringify(updatedCart));
  };

  const calculateTotal = () => {
    return cart.reduce((total, item) => total + item.price, 0);
  };

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-bold mb-4">Warenkorb</h1>
      <div className="space-y-4">
        {cart.map((item) => (
          <div key={item.id} className="flex justify-between items-center">
            <p>{item.name}</p>
            <p>${item.price}</p>
            <button onClick={() => removeFromCart(item.id)} className="text-red-500">Entfernen</button>
          </div>
        ))}
      </div>
      <div className="mt-6 flex justify-between">
        <p className="font-bold">Gesamt: ${calculateTotal()}</p>
        <button className="bg-blue-500 text-white px-4 py-2 rounded">Zur Kasse</button>
      </div>
    </div>
  );
}

export default Cart;
