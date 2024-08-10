import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data")
    val data: List<User>
)

data class User(
    @SerializedName("id")
    val id: Int,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("avatar")
    val avatar: String
) {
    val fullName: String
        get() = "$firstName $lastName"
}
