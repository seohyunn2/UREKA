import React, { useState } from "react";

function SelectF(props) {
  const [value, setValue] = useState("mango");
  const flavors = [
    { key: "grapefruit", value: "포도" },
    { key: "lime", value: "라임" },
    { key: "coconut", value: "코코넛" },
    { key: "mango", value: "Mango" },
  ];

  const handleChange = (e) => {
    setValue(e.target.value);
  };

  const flavorList = flavors.map((f) => <option value={f.key}>{f.value}</option>);
  return (
    <form>
      <label>
        Pick your favorite flavor:
        <select value={value} onChange={handleChange}>
          {flavorList}
        </select>
      </label>
      <input type="submit" value="Submit" />
    </form>
  );
}

export default SelectF;
