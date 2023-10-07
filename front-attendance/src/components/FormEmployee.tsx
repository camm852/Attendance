import { Tab } from "@headlessui/react";
import React from "react";
import Camera from "react-html5-camera-photo";
import "react-html5-camera-photo/build/css/index.css";
import baseUrl from "../utils/api";

const FormEmployee = () => {
  const [cameraPermissions, setCameraPersmissions] =
    React.useState<boolean>(false);
  const [selectedFile, setSelectedFile] = React.useState<File | null>(null);
  const [photo, setPhoto] = React.useState<Blob | null>(null);

  const [employee, setEmployee] = React.useState<{
    id: string;
    name: string;
    photo: string;
  }>({
    photo: "",
    id: "",
    name: "",
  });

  React.useEffect(() => {
    const requestCameraPermission = async () => {
      try {
        await navigator.mediaDevices.getUserMedia;

        setCameraPersmissions(true);
      } catch (error) {
        console.error("Error al acceder a la cámara:", error);
      }
    };
    requestCameraPermission();
  }, []);

  const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    if (event.target.files) {
      setSelectedFile(event.target.files[0]);
    }
  };

  const handleChangeForm = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEmployee({
      ...employee,
      [event.target.name]: event.target.value,
    });
  };

  const handleChangeTab = (index: number) => {
    setSelectedFile(null);
    setPhoto(null);
  };

  const handleTakePhoto = (dataUri: string) => {
    const data = dataUri.split(",");
    const base64String = data[1]; // Base64 string
    const binaryString = atob(base64String); // Binary data string
    const blob = new Blob([binaryString], {
      type: data[0].split(":")[1].split(";")[0],
    }); // Create a BLOB object
    setPhoto(blob);
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    try {
      const response = await baseUrl.post("/api/v1/employees", employee, {
        headers: {
          "Content-Type": "application/json",
        },
      });

      console.log(response);

      // const formData = new FormData();
      // if (photo) formData.append("photo", photo);
      // if (selectedFile) formData.append("file", selectedFile);
    } catch (error) {
      console.error(error);
    }
  };

  const type = {
    "Upload File": [
      {
        html: (
          <div className="max-w-2xl mx-auto">
            <label
              className="block mb-2 text-sm font-medium text-gray-900 "
              htmlFor="file_input"
            >
              Upload file
            </label>
            <input
              className="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
              id="file_input"
              type="file"
              accept="image/*"
              onChange={handleFileChange}
            />
          </div>
        ),
      },
    ],
    "Take Photo": [
      {
        html: (
          <div className="max-w-2xl mx-auto">
            {cameraPermissions ? (
              <Camera
                isImageMirror={true}
                onTakePhoto={(dataUri: string) => {
                  handleTakePhoto(dataUri);
                }}
              />
            ) : (
              <p>Camera permissions denied</p>
            )}
          </div>
        ),
      },
    ],
  };

  const classNames = (...classes) => {
    return classes.filter(Boolean).join(" ");
  };

  return (
    <>
      <form onSubmit={handleSubmit}>
        <div className="flex flex-wrap -mx-3 mb-2 h-32">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label
              className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
              htmlFor="id"
            >
              Employee ID
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border  py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
              id="id"
              name="id"
              type="text"
              placeholder="10"
              onChange={handleChangeForm}
            />
          </div>
          <div className="w-full md:w-1/2 px-3">
            <label
              className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
              htmlFor="name"
            >
              Employee Name
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white "
              id="name"
              name="name"
              type="text"
              placeholder="Doe"
              onChange={handleChangeForm}
            />
          </div>
        </div>
        {employee.name !== "" && employee.id !== "" && (
          <div className="w-full max-w-md px-2 py-8 sm:px-0">
            <Tab.Group onChange={handleChangeTab}>
              <Tab.List className="flex space-x-1 rounded-xl bg-blue-900/20 p-1">
                {Object.keys(type).map((typeMethod) => (
                  <Tab
                    key={typeMethod}
                    className={({ selected }) =>
                      classNames(
                        "w-full rounded-lg py-2.5 text-sm font-medium leading-5 text-blue-700",
                        "ring-white ring-opacity-60 ring-offset-2  focus:outline-none focus:ring-2",
                        selected
                          ? "bg-white shadow"
                          : "text-blue-100 hover:bg-white/[0.12] hover:text-white"
                      )
                    }
                  >
                    {typeMethod}
                  </Tab>
                ))}
              </Tab.List>
              <Tab.Panels className="mt-2">
                {Object.values(type).map((typeValue, idx) => (
                  <Tab.Panel
                    key={idx}
                    className={classNames(
                      "rounded-xl bg-white p-3",
                      "ring-white ring-opacity-60 ring-offset-2  focus:outline-none focus:ring-2"
                    )}
                  >
                    {typeValue[0].html}
                  </Tab.Panel>
                ))}
              </Tab.Panels>
            </Tab.Group>
          </div>
        )}
        <button className="w-full bg-indigo-600 p-2 text-white rounded hover:bg-indigo-500">
          Created Employee
        </button>
      </form>
    </>
  );
};

export default FormEmployee;
