import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Checkout() {
  const navigate = useNavigate();
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [paymentInfo, setPaymentInfo] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    // Hier könnte man die Bestellung an den Backend-Service senden
    alert("Bestellung abgeschlossen!");
    localStorage.removeItem("cart");  // Warenkorb leeren nach dem Bestellabschluss
    navigate("/");
  };

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-bold mb-4">Checkout</h1>
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="block text-lg">Name</label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            className="w-full p-2 border rounded"
            required
          />
        </div>
        <div>
          <label className="block text-lg">Adresse</label>
          <input
            type="text"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            className="w-full p-2 border rounded"
            required
          />
        </div>
        <div>
          <label className="block text-lg">Zahlungsinformationen</label>
          <input
            type="text"
            value={paymentInfo}
            onChange={(e) => setPaymentInfo(e.target.value)}
            className="w-full p-2 border rounded"
            required
          />
        </div>
        <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded">Bestellung abschließen</button>
      </form>
    </div>
  );
}

export default Checkout;
